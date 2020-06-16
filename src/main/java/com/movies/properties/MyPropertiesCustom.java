package com.movies.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by DostM on 6/16/2020.
 */
@Component
@Data
@ConfigurationProperties(prefix = "io.com")
public class MyPropertiesCustom {
    private String message;
    private String messageRoot;
}
