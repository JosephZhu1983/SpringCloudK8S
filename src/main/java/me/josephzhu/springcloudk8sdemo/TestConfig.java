package me.josephzhu.springcloudk8sdemo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "bean")
@Data
public class TestConfig {
    private String message;
    private String serviceName;
}