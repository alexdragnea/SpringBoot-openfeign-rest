package net.dg.springbootopefeignrestapi.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor
public class CatApiAuthInterceptor implements RequestInterceptor {

    private final CatApiProperties properties;

    @Override
    public void apply(RequestTemplate template) {
        if (StringUtils.isNotBlank(properties.getApiKey())) {
            template.header("x-api-key", properties.getApiKey());
        }
    }

}
