package org.linlinjava.litemall.db.util;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonConfigLoader {
    public static String getJson(String filename) {
        try {
            ClassPathResource resource = new ClassPathResource("data/" + filename);
            InputStream inputStream = resource.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            return String.join("", IOUtils.readLines(reader));
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
    }
}
