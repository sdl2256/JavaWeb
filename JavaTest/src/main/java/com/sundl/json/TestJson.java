package com.sundl.json;

import com.alibaba.fastjson.JSON;
import com.sundl.shipxy.SShipInfo;

/**
 * Created by SDL on 2015/5/14.
 */
public class TestJson {

    public static void main(String[] args) {

        Double d = new Double(2.22);


        String test = "{\"@type\":\"com.sundl.shipxy.SShipInfo\",\"callsign\":\"BRWN\",\"cog\":228,\"day\":21,\"dest\":\"ZHU HAI             \",\"draught\":13.3,\"hdg\":0,\"hour\":12,\"imo\":9061576," +
                "\"lastTime\":{\"@type\":\"com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl\",\"day\":20,\"eonAndYear\":2014,\"hour\":5,\"millisecond\":-2147483648,\"minute\":40,\"month\":6,\"second\":50,\"timezone\":-2147483648,\"valid\":true,\"xMLSchemaType\":{\"localPart\":\"dateTime\",\"namespaceURI\":\"http://www.w3.org/2001/XMLSchema\",\"prefix\":\"\"},\"year\":2014},\"lat\":23.067778,\"left\":225,\"length\":225,\"lng\":117.199861,\"minute\":0,\"mmsi\":413335000,\"month\":6,\"name\":\"YUE DIAN 4\",\"naviStatus\":15,\"naviStatusCn\":\"\",\"naviStatusEn\":\"\",\"rot\":0,\"shipType\":70,\"shipTypeCn\":\"货船\",\"shipTypeEn\":\"Cargo ship\",\"sog\":11.338444924406048,\"trail\":32,\"width\":32}";

        SShipInfo testObj = JSON.parseObject(test, SShipInfo.class);
//        Shipxy testObj2 = JSON.parseObject(test, Shipxy.class);
        System.out.println(testObj.getName());
//        System.out.println(testObj2.getName());
    }
}
