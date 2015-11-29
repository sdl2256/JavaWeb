package com.sundl.json;

import com.alibaba.fastjson.JSON;

/**
 * Created by SDL on 2015/11/16.
 */
public class TestJsonCompass {

    public static void main(String[] args) {
        String compass = "{\"@type\":\"cn.maritech.dss.device.data.CompassData\"," +
                "\"date\":1447665358162,\"deviceId\":\"COMPASS\",\"deviceType\":\"COMPASS\"," +
                "\"heading\":80.51}";//,\"rateOfTurn\":-0.4D}";
        String gps =
                "{\"@type\":\"cn.maritech.dss.device.data.GPSData\"," +
                        "\"altitude\":26,\"correctedCourse\":45,\"course\":45,\"date\":1447665359186," +
                        "\"deviceId\":\"GPS\",\"deviceType\":\"GPS\",\"latitude\":19.658067,\"longitude\":111.117483," +
                        "\"satellitesInUse\":9,\"speed\":21,\"utc\":1447665359000}";


        cn.maritech.dss.device.data.CompassData compassData = JSON.parseObject(compass, cn.maritech.dss.device.data.CompassData.class);
        System.out.println(compassData);

        CompassData cmData = new CompassData();
        cmData.setHeading(compassData.getHeading());
        cmData.setRateOfTurn(compassData.getRateOfTurn());

        cmData.setDate(compassData.getDate());
        System.out.println(cmData);
        cn.maritech.dss.device.data.GPSData gpsData = JSON.parseObject(gps, cn.maritech.dss.device.data.GPSData.class);
        System.out.println(gpsData);
    }
}
