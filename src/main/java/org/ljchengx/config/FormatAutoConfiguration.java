package org.ljchengx.config;

import org.ljchengx.stringformt.FormatProcessor;
import org.ljchengx.stringformt.JsonFormatProcessor;
import org.ljchengx.stringformt.StringFormatProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author ljchengx
 * @date 2021/5/18 11:11
 */
@Configuration
public class FormatAutoConfiguration {


    @Bean
    @Primary
    @ConditionalOnMissingClass("com.alibaba.fastjson.JSON")
    public FormatProcessor stringFormat() {
        return new StringFormatProcessor();
    }


    @Bean
    @ConditionalOnClass(name = "com.alibaba.fastjson.JSON")
    public FormatProcessor jsonFormat() {
        return new JsonFormatProcessor();
    }

}
