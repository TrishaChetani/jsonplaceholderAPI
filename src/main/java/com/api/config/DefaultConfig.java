package com.api.config;

import java.io.*;
import java.util.Properties;


public class DefaultConfig {


    public final String CURRENT_DIR = System.getProperty("user.dir");
    public final String baseURI = System.getProperty("baseURI");
    public final String createEndPoint = "/api/v1/create";
    public final String viewDetailEndPoint = "/api/v1/employees";
    public final String viewDetailByIdEndPoint = "/api/v1/employee/{employeeId}";
    public final String deleteRecordEndpoint = "/api/v1/delete/{employeeId}";


    public void test() throws IOException {
        Properties prop = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(System.getProperty("env"));
        prop.load(inputStream);
    }

}






