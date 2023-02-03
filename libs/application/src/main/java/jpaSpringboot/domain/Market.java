package jpaSpringboot.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "markets")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "market_id")
    private int marketId;

    @Column(name = "market_symbol")
    private String marketSymbol;

    @Column(name = "market_korean_name")
    private String koreanName;

    @Column(name = "market_english_name")
    private String englishName;

    @Builder
    public Market(String marketSymbol,
                  String koreanName,
                  String englishName) {
        this.marketSymbol = marketSymbol;
        this.koreanName = koreanName;
        this.englishName = englishName;
    }
}
