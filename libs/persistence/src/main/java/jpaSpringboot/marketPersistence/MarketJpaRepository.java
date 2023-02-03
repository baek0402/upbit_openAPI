package jpaSpringboot.marketPersistence;

import jpaSpringboot.domain.Market;
import jpaSpringboot.port.out.market.MarketDBPort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MarketJpaRepository extends QuerydslRepositorySupport implements MarketDBPort {

    public MarketJpaRepository() {
        super(Market.class);
    }

    @PersistenceContext
    @Override
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }

    @Override
    public void save(Market market) {
        EntityManager entityManager = getEntityManager();
        Assert.notNull(entityManager, "Entity manager must not null.");
        entityManager.persist(market);
        entityManager.flush();
    }

    @Override
    public List<Market> search(String marketName, String koreanName, String englishName) {
        /*
        QMarket qMarket = QMarket.market;
        return selectFrom(qMarket).fetch();
        */
        //이거면 그냥 db에 저장된거 다 가져오는거임
        return null;
    }
}
