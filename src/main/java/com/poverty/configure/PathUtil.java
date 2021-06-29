package com.poverty.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/27 11:00
 */
@Component
@ConfigurationProperties(prefix="path")
@Data
public class PathUtil {
    private String htmlPath;
    private String imagePath;
    private String videoPath;
    private String docxPath;
}
