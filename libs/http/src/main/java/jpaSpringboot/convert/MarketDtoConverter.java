package jpaSpringboot.convert;

import jpaSpringboot.converter.MapStructConfig;
import jpaSpringboot.domain.Market;
import jpaSpringboot.market.UpbitMarket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface MarketDtoConverter {

    @Mapping(source = "market", target = "marketSymbol")
    Market convert(UpbitMarket source);

    @Mapping(source = "market", target = "marketSymbol")
    List<Market> convert(List<UpbitMarket> sources);

}
