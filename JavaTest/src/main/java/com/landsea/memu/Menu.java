package com.landsea.memu;

/**
 * Created by SDL on 2015/7/13.
 */
public class Menu {
    private String name;
    private String url;
    private String paraShipid;
    private String paraUserid;
    private String order;
    private String showMaxSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParaShipid() {
        return paraShipid;
    }

    public void setParaShipid(String paraShipid) {
        this.paraShipid = paraShipid;
    }

    public String getParaUserid() {
        return paraUserid;
    }

    public void setParaUserid(String paraUserid) {
        this.paraUserid = paraUserid;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getShowMaxSize() {
        return showMaxSize;
    }

    public void setShowMaxSize(String showMaxSize) {
        this.showMaxSize = showMaxSize;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", paraShipid='" + paraShipid + '\'' +
                ", paraUserid='" + paraUserid + '\'' +
                ", order='" + order + '\'' +
                ", showMaxSize='" + showMaxSize + '\'' +
                '}';
    }
}
