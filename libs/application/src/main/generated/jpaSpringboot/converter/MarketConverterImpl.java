package jpaSpringboot.converter;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import jpaSpringboot.domain.Market;
import jpaSpringboot.port.in.market.MarketDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-03T23:16:47+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class MarketConverterImpl implements MarketConverter {

    @Override
    public MarketDto convert(Market source) {
        if ( source == null ) {
            return null;
        }

        MarketDto.MarketDtoBuilder marketDto = MarketDto.builder();

        marketDto.market( source.getMarketSymbol() );
        marketDto.koreanName( source.getKoreanName() );
        marketDto.englishName( source.getEnglishName() );

        return marketDto.build();
    }

    @Override
    public List<MarketDto> convert(List<Market> sources) {
        if ( sources == null ) {
            return null;
        }

        List<MarketDto> list = new ArrayList<MarketDto>( sources.size() );
        for ( Market market : sources ) {
            list.add( convert( market ) );
        }

        return list;
    }
}
