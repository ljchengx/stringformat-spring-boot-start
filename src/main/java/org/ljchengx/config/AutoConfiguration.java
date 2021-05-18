package org.ljchengx.config;

import org.ljchengx.FormatTemPlate;
import org.ljchengx.stringformt.FormatProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ljchengx
 * @date 2021/5/18 11:13
 */
@Configuration
@Import(FormatAutoConfiguration.class)
@EnableConfigurationProperties(FormatProperties.class)
public class AutoConfiguration {

    @Bean
    public FormatTemPlate autoConfiguration(FormatProcessor formatProcessor,FormatProperties formatProperties) {
        return new FormatTemPlate(formatProcessor,formatProperties);
    }

}
