package com.template.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.core.env.*;
import springfox.documentation.swagger2.annotations.*;

@EnableSwagger2
@Configuration
@Profile("DEVELOPMENT")
public class DevelopmentTemplateConfiguration {

    @Autowired private Environment environment;
}
