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
    String sayHello(@WebParam(name = "username") String username);

    @WebMethod
    Date getDateNow();

    @WebMethod
    Date getDate(@WebParam(name = "date") Date date);

    void setUser(String username);

}
