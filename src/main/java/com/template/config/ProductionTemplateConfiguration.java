package com.template.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.core.env.*;

@Configuration
@Profile("PRODUCTION")
public class ProductionTemplateConfiguration implements TemplateConfiguration {

    @Autowired private Environment environment;
}
