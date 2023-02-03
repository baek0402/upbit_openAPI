package jpaSpringboot.converter;

import jpaSpringboot.domain.Market;
import jpaSpringboot.port.in.market.MarketDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface MarketConverter {
/*
    public MarketDto convert(Market source) {
        return MarketDto.builder()
                .market(source.getMarket())
                .koreanName(source.getKoreanName())
                .englishName(source.getEnglishName())
                .build();
    }*/

    @Mapping(source = "marketSymbol", target = "market")
    MarketDto convert(Market source);

    @Mapping(source = "marketSymbol", target = "market")
    List<MarketDto> convert(List<Market> sources);
}
