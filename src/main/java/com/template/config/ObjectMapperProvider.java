package com.template.config;

import com.fasterxml.jackson.databind.*;
import org.springframework.stereotype.*;

@Component
public class ObjectMapperProvider {
    private final ObjectMapper objectMapper;

    public ObjectMapperProvider() {
        objectMapper =
                new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
