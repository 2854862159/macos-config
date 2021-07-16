package com.example.macosconfig.config;

import org.springframework.core.env.PropertySource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ClassName: MacosPropertySource <br/>
 * Description: <br/>
 * date: 2021/7/15 10:33 下午<br/>
 *
 * @author tooru<br />
 */
public class MacosPropertySource extends PropertySource<MacosItem> {

    private Map<String, String> properties = new LinkedHashMap();

    public MacosPropertySource(String name, MacosItem macosItem) throws IOException {
        super(name, macosItem);
        Files.lines(Paths.get(macosItem.getPath()), StandardCharsets.UTF_8).forEach(line -> {
            System.out.println(macosItem.getPath() + " " + line);
            String[] split = line.split("=");
            properties.put(split[0], split[1]);
        });
    }

    @Override
    public Object getProperty(String s) {
        return properties.get(s);
    }
}
