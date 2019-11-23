package com.template;

import com.template.config.*;
import org.slf4j.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.*;

@SpringBootApplication
public class TemplateServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateServiceApplication.class);

    public static void main(String[] args) {
        start(args);
    }

    public static ApplicationContext start(final String[] additionalProfiles, final String[] args) {
        final SpringApplication application = new SpringApplication(TemplateServiceApplication.class);
        String[] allProfiles;
        if (additionalProfiles != null) {
            allProfiles = new String[additionalProfiles.length + 1];
            System.arraycopy(additionalProfiles, 0, allProfiles, 0, additionalProfiles.length);
            allProfiles[additionalProfiles.length] = getProfileToLoad().name();
        } else {
            allProfiles = new String[] {getProfileToLoad().name()};
        }

        application.setAdditionalProfiles(allProfiles);

        return application.run(args);
    }

    public static ApplicationContext start(final String[] args) {
        return start(new String[] {}, args);
    }

    private static Stage getProfileToLoad() {
        final String officialStage = System.getenv("DRP_CF_STAGE");
        if (officialStage == null) {
            LOGGER.warn(
                    "No stage selected. If you're developing set the environment variable DRP_CF_STAGE to either 'dev' or 'pp'. Falling back to production 'prod'.");
            return Stage.PRODUCTION;
        }
        switch (officialStage) {
            case "pp":
                return Stage.PREPRODUCTION;
            case "dev":
                return Stage.DEVELOPMENT;
            default:
                LOGGER.warn(
                        "Stage '" + officialStage + "' not recognized. Falling back to 'prod'.");
            case "prod":
                return Stage.PRODUCTION;
        }
    }
}
