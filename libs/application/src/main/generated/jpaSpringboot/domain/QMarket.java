package jpaSpringboot.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMarket is a Querydsl query type for Market
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMarket extends EntityPathBase<Market> {

    private static final long serialVersionUID = 1830398610L;

    public static final QMarket market = new QMarket("market");

    public final StringPath englishName = createString("englishName");

    public final StringPath koreanName = createString("koreanName");

    public final NumberPath<Integer> marketId = createNumber("marketId", Integer.class);

    public final StringPath marketSymbol = createString("marketSymbol");

    public QMarket(String variable) {
        super(Market.class, forVariable(variable));
    }

    public QMarket(Path<? extends Market> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMarket(PathMetadata metadata) {
        super(Market.class, metadata);
    }

}

