package com.sundl.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * Created by SDL on 2015/5/8.
 */

public class UserLoginAction extends ActionSupport {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String user_login() throws Exception {
        return SUCCESS;
    }

    public String login() throws Exception {
        System.out.println("name-->" + name);
        System.out.println("password-->" + password);
        return SUCCESS;
    }
}
