package jpaSpringboot.marketPersistence;

import jpaSpringboot.domain.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketCreateJpaRepositry extends JpaRepository<Market, Integer> {

}
