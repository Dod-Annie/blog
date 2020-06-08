package com.dodannie.blog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Dod_Annie
 * @description
 * @date 2020/5/30 21:25
 */
@Data
@Component
@ConfigurationProperties(prefix = "upload")
public class UploadConfig {

    private String baseUrl;
    private List<String> allowTypes;

}
