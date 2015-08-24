package com.sundl.demo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;

/**
 * Created by SDL on 2015/6/5.
 */
@WebService
public interface IHelloWorld {
    @WebMethod
    public String sayHello(@WebParam(name = "username") String username);
    @WebMethod
    public Date getDateNow();
    @WebMethod
    public Date getDate(@WebParam(name = "date") Date date);
    public void setUser(String username);

}
