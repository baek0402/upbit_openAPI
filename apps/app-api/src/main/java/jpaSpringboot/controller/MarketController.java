package jpaSpringboot.controller;

import jpaSpringboot.port.SearchMarketUsecase;
import jpaSpringboot.port.in.market.MarketDto;
import jpaSpringboot.response.ResultResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarketController{

    private SearchMarketUsecase searchMarketUsecase;

    public MarketController(SearchMarketUsecase searchMarketUsecase) {
        this.searchMarketUsecase = searchMarketUsecase;
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

}

