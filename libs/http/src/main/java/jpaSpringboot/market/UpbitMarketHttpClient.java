package jpaSpringboot.market;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jpaSpringboot.contract.UpbitRequestType;
import jpaSpringboot.convert.MarketDtoConverter;
import jpaSpringboot.domain.Market;
import jpaSpringboot.domain.UpbitRequestQuery;
import jpaSpringboot.port.out.market.MarketHttpPort;
import jpaSpringboot.util.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static java.util.UUID.randomUUID;

@Service
public class UpbitMarketHttpClient implements MarketHttpPort {

    private final MarketDtoConverter marketDtoConverter;
    private final JsonDeserializer jsonDeserializer;

    public UpbitMarketHttpClient(MarketDtoConverter marketDtoConverter, JsonDeserializer jsonDeserializer) {
        this.marketDtoConverter = marketDtoConverter;
        this.jsonDeserializer = jsonDeserializer;
    }

    @Override
    public List<Market> getAllMarkets() {
        UpbitRequestType requestType = UpbitRequestType.MARKET_ALL_V1;
        UpbitRequestQuery query = UpbitRequestQuery.builder()
                .url(UpbitRequestType.getFullUrl(requestType))
                .body(null)
                //.param("isDetails=" + clause.isDetails())
                .method(HttpMethod.GET)
                .build();
        String data = request(query);
        List<UpbitMarket> result = jsonDeserializer.deserializeAsList(data, UpbitMarket.class);
        return marketDtoConverter.convert(result);
    }

    public String request(UpbitRequestQuery query) {
        String authToken = getAuthToken(query.getParam());
        try {
            URL url = new URL(query.getUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(query.getMethod().name());
            conn.setRequestProperty("Authorization", authToken);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            //StringUtils : lang3 added
            if (StringUtils.isNotBlank(query.getBody())) {
                //if(query.getBody() != null || !Objects.equals(query.getBody(), "")) {
                OutputStream os = conn.getOutputStream();
                os.write(query.getBody().getBytes());
                os.flush();
            }

            return getApiResponse(conn);
        } catch (Exception e) {
            //log.error("failed to request API with auth: {}", e.getMessage());
            //throw new InvalidUpbitRequestException("failed to request API with auth");
            throw new RuntimeException("failed to request API with auth");
        }
    }

    private String getAuthToken(String query) {
        String accessKey = "hvCPqhBBpTtWRGeuiWKxaRx9FBeeu7pXb04TI3AQ";
        String secretKey = "XgT2dIwVuYc9ZyequvCNRsD5R6hlqyJSAmxh4b3t";
        Algorithm algo = Algorithm.HMAC256(secretKey);

        if (StringUtils.isBlank(query)) {
            return "Bearer " + JWT.create()
                    .withClaim("access_key", accessKey)
                    .withClaim("nonce", randomUUID().toString())
                    .sign(algo);
        }

        return "Bearer " + JWT.create()
                .withClaim("access_key", accessKey)
                .withClaim("nonce", randomUUID().toString())
                .withClaim("query", query)
                .sign(algo);
    }

    private String getApiResponse(HttpURLConnection conn) {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            br.close();

            return stringBuilder.toString();
        } catch (Exception e) {
            //log.error("failed to get api response: {}", e.getMessage(), e);
            throw new RuntimeException("failed to get api response");
        }
    }
}
