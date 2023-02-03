package jpaSpringboot.service.market;

import jpaSpringboot.converter.MarketConverter;
import jpaSpringboot.domain.Market;
import jpaSpringboot.port.SearchMarketUsecase;
import jpaSpringboot.port.in.market.MarketDto;
import jpaSpringboot.port.out.market.MarketHttpPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchMarketService implements SearchMarketUsecase {

    private final MarketHttpPort marketHttpPort;
    private final MarketConverter marketConverter;
    public SearchMarketService(MarketHttpPort marketHttpPort, MarketConverter marketConverter) {
        this.marketHttpPort = marketHttpPort;
        this.marketConverter = marketConverter;
    }

    @Override
    public MarketDto getByName(String name) {
        List<Market> result = marketHttpPort.getAllMarkets();
        Market filtered = result.stream()
                .filter(each -> each.getMarketSymbol().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("유효하지 않는 값입니다. %s",name)));

        return marketConverter.convert(filtered);
    }

    @Override
    public List<MarketDto> getAllMarkets() {
        List<Market> result = marketHttpPort.getAllMarkets();
        return marketConverter.convert(result);
    }
}
