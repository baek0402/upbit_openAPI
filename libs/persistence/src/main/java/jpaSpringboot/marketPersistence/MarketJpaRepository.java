package jpaSpringboot.marketPersistence;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jpaSpringboot.domain.Market;
import jpaSpringboot.domain.QMarket;
import jpaSpringboot.port.out.market.MarketDBPort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.querydsl.jpa.JPAExpressions.selectFrom;

@Repository
public class MarketJpaRepository extends QuerydslRepositorySupport implements MarketDBPort {

    public MarketCreateJpaRepositry marketCreateJpaRepositry;

    public MarketJpaRepository(MarketCreateJpaRepositry marketCreateJpaRepositry) {
        super(Market.class);
        this.marketCreateJpaRepositry = marketCreateJpaRepositry;
    }

    @PersistenceContext
    @Override
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }

    @Override
    public void save(Market market) {
        marketCreateJpaRepositry.save(market);
        /*EntityManager entityManager = getEntityManager();
        Assert.notNull(entityManager, "Entity manager must not null.");
        entityManager.persist(market);
        entityManager.flush();*/
    }

    @Override
    public List<Market> search(String marketName, String koreanName, String englishName) {
        /*
        QMarket qMarket = QMarket.market;
        return selectFrom(qMarket).fetch();
        */

        JPAQueryFactory query = new JPAQueryFactory(getEntityManager());
        QMarket qMarket = QMarket.market;
        BooleanBuilder condition = new BooleanBuilder();
        condition.and(qMarket.marketSymbol.eq(marketName));
        return query.selectFrom(qMarket).where(condition).fetch();
    }

}
