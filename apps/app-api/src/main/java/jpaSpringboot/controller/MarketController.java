package jpaSpringboot.controller;

import jpaSpringboot.port.CreateMarketUsecase;
import jpaSpringboot.port.SearchMarketUsecase;
import jpaSpringboot.port.in.market.MarketDto;
import jpaSpringboot.response.ResultResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarketController{

    private SearchMarketUsecase searchMarketUsecase;
    private CreateMarketUsecase createMarketUsecase;
    public MarketController(SearchMarketUsecase searchMarketUsecase, CreateMarketUsecase createMarketUsecase) {
        this.searchMarketUsecase = searchMarketUsecase;
        this.createMarketUsecase = createMarketUsecase;
    }

    @GetMapping("/api/v1/market/{name}")
    public MarketDto market(@PathVariable String name) {
        return searchMarketUsecase.getByName(name);
    }

    @GetMapping(value = "/v1/market/all") //@GetMapping("/v1/market/all") 로 해도 됨
    public ResultResponse<List<MarketDto>> getMarkets() {
        List<MarketDto> result = searchMarketUsecase.getAllMarkets();
        return ResultResponse.success(result);
    }

    @PostMapping(value = "/v1/market/create")
    public ResultResponse<Void> create (
            @RequestBody MarketCreateRequestBody requestBody) {
        createMarketUsecase.create(
                requestBody.getMarket(),
                requestBody.getKoreanName(),
                requestBody.getEnglishName()
        ); //이렇게 세가지를 넘겨본대
        return ResultResponse.success();
    }

}

