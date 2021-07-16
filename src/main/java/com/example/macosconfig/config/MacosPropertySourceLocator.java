package com.example.macosconfig.config;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * ClassName: MacosPropertySourceLocator <br/>
 * Description: <br/>
 * date: 2021/7/15 10:26 下午<br/>
 *
 * @author tooru<br />
 */
public class MacosPropertySourceLocator implements PropertySourceLocator {

    private final String BASE_PATH = System.getProperty("user.dir") + "/myconfig";

    @Override
    public PropertySource<?> locate(Environment environment) {
        String[] activeProfiles = environment.getActiveProfiles();
        CompositePropertySource composite = new CompositePropertySource("macos");
        Arrays.stream(activeProfiles).forEach(profile -> {
            MacosItem macosItem = new MacosItem();
            macosItem.setPath(BASE_PATH + "/" + profile + "/macos.properties");
            macosItem.setFile(new File(BASE_PATH + "/macos.properties"));
            try {
                MacosPropertySource macosPropertySource = new MacosPropertySource(BASE_PATH + "#" + profile, macosItem);
                composite.addPropertySource(macosPropertySource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return composite;
    }
}
