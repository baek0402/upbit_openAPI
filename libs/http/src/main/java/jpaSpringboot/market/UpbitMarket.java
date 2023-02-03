package jpaSpringboot.market;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class UpbitMarket {
    private String market;

    @SerializedName("korean_name")
    private String koreanName;

    @SerializedName("english_name")
    private String englishName;
}
