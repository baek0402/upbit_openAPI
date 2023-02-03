package jpaSpringboot.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

@Component
public class JsonDeserializer {
    private final GsonUtil gsonUtil;

    public JsonDeserializer(GsonUtil gsonUtil) {
        this.gsonUtil = gsonUtil;
    }

    public <T> List<T> deserializeAsList(String data, Class<T> classOfT) {
        //if (StringUtils.isBlank(data)) {
        if(data == null) {
            return Collections.emptyList();
            //return new ArrayList<>();
        }

        Type type = new ListParameterizedType(classOfT);
        return gsonUtil.fromJson(data, type);
    }
}


