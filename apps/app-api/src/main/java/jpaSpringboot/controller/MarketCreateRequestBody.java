package jpaSpringboot.controller;

import lombok.Builder;
import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter
public class MarketCreateRequestBody {
    private final String market;
    private final String koreanName;
    private final String englishName;

    @Builder
    //이거를 설정 해줘야 json data를 잘 읽어온대
    @ConstructorProperties({"market", "koreanName", "englishName"})
    public MarketCreateRequestBody(String market, String koreanName, String englishName) {
        this.market = market;
        this.koreanName = koreanName;
        this.englishName = englishName;
    }
}
