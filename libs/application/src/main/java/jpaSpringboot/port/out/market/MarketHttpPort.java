package jpaSpringboot.port.out.market;

import jpaSpringboot.domain.Market;

import java.util.List;

public interface MarketHttpPort {

    public List<Market> getAllMarkets();
}

