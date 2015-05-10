package com.sundl.spring.helloworld;

import java.util.Properties;

/**
 * Created by Sun on 2015/5/9.
 */
public class MyDataSource {
    private Properties properties;

    @Override
    public String toString() {
        return "MyDataSource{" +
                "properties=" + properties +
                '}';
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
