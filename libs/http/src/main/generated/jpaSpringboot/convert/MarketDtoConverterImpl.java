package jpaSpringboot.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import jpaSpringboot.converter.SupportValidation;
import jpaSpringboot.domain.Market;
import jpaSpringboot.market.UpbitMarket;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-03T23:16:48+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class MarketDtoConverterImpl implements MarketDtoConverter {

    @Override
    public Market convert(UpbitMarket source) {
        if ( source == null ) {
            return null;
        }

        Market.MarketBuilder market = Market.builder();

        market.marketSymbol( source.getMarket() );
        market.koreanName( source.getKoreanName() );
        market.englishName( source.getEnglishName() );

        return market.build();
    }

    @Override
    public List<Market> convert(List<UpbitMarket> sources) {
        if ( sources == null ) {
            return null;
        }

        List<Market> list = new ArrayList<Market>( sources.size() );
        for ( UpbitMarket upbitMarket : sources ) {
            list.add( convert( upbitMarket ) );
        }

        return list;
    }
}
