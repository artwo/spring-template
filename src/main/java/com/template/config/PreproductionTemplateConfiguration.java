package com.template.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.*;

@EnableSwagger2
@Configuration
@Profile("PREPRODUCTION")
public class PreproductionTemplateConfiguration {

    @Autowired private Environment environment;
}
