package jpaSpringboot.port.in.market;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MarketDto {

    private String market;
    private String koreanName;
    private String englishName;

    @Builder
    public MarketDto(String market, String koreanName, String englishName) {
        this.market = market;
        this.koreanName = koreanName;
        this.englishName = englishName;
    }
}
