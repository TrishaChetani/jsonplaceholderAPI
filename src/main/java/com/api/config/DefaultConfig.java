package com.api.config;

import java.io.*;
import java.util.Properties;


public class DefaultConfig {


    public final String CURRENT_DIR = System.getProperty("user.dir");
    public final String baseURI = System.getProperty("baseURI");
    public final String createEndPoint = "/posts";
    public final String viewDetailEndPoint = "/posts";
    public final String viewDetailByIdEndPoint = "posts/{id}";
    public final String deleteRecordEndpoint = "/posts/{id}";


    public void test() throws IOException {
        Properties prop = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(System.getProperty("env"));
        prop.load(inputStream);
    }

}






