package jpaSpringboot.port;

import jpaSpringboot.port.in.market.MarketDto;

import java.util.List;

public interface SearchMarketUsecase {
    MarketDto getByName(String name);

    List<MarketDto> getAllMarkets();

    List<MarketDto> search(String marketName, String koreanName, String englishName);
}
