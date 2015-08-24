package com.landsea.memu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDL on 2015/7/13.
 */
public class MenuButtonConfig {
    private String id;
    private String name;
    private String type = "PopUp";
    private String urlTemplate;
    private String userName = "";
    private String password = "";
    private List<String> urlParams = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrlTemplate() {
        return urlTemplate;
    }

    public void setUrlTemplate(String urlTemplate) {
        this.urlTemplate = urlTemplate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getUrlParams() {
        return urlParams;
    }

    public void setUrlParams(List<String> urlParams) {
        this.urlParams = urlParams;
    }

    @Override
    public String toString() {
        return "MenuButtonConfig{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", urlTemplate='" + urlTemplate + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", urlParams=" + urlParams +
                '}';
    }
}
