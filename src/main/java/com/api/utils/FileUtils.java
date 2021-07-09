package com.api.utils;

import com.api.config.DefaultConfig;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class FileUtils {
    public  DefaultConfig defaultConfig = new DefaultConfig();
    public String  readFile(String filePath) throws IOException {
        File file = new File(defaultConfig.CURRENT_DIR + filePath);
        StringBuilder fileContents = new StringBuilder((int) file.length());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + System.lineSeparator());
            }
            String jsonString = fileContents.toString();
            return jsonString;
        }
    }
}
