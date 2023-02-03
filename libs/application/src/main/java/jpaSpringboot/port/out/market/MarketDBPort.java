package jpaSpringboot.port.out.market;



import jpaSpringboot.domain.Market;

import java.util.List;

public interface MarketDBPort {
    //db랑 연결되는 interface

    void save(Market market);

    List<Market> search(String marketName, String koreanName, String englishName);
}
