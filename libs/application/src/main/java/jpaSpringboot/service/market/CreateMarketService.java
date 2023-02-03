package jpaSpringboot.service.market;

import jpaSpringboot.domain.Market;
import jpaSpringboot.port.CreateMarketUsecase;
import jpaSpringboot.port.out.market.MarketDBPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateMarketService implements CreateMarketUsecase {

    private final MarketDBPort marketDBPort;

    public CreateMarketService(MarketDBPort marketDBPort) {
        this.marketDBPort = marketDBPort;
    }

    @Override
    @Transactional
    public void create(String marketName, String koreanName, String englishName) {
        //create하는 메소드를 하나의 트랜잭션으로 묶기
        //먼저 queryDSL을 통해서 한대..
        marketDBPort.save(
                Market.builder()
                        .marketSymbol(marketName)
                        .koreanName(koreanName)
                        .englishName(englishName)
                        .build()
        );
    }
}
