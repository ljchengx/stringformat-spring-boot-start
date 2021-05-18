package org.ljchengx.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @author ljchengx
 * @date 2021/5/18 13:44
 */
@Component
@ConfigurationProperties(prefix = "ljchengx")
public class FormatProperties {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
