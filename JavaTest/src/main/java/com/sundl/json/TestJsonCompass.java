package com.sundl.json;

import com.alibaba.fastjson.JSON;

/**
 * Created by SDL on 2015/11/16.
 */
public class TestJsonCompass {

    public static void main(String[] args) {
        String compass = "{\"@type\":\"com.sundl.json.CompassData\"," +
                "\"date\":1447665358162,\"deviceId\":\"COMPASS\",\"deviceType\":\"COMPASS\"," +
                "\"heading\":43.4}";//,\"rateOfTurn\":-0.4D}";
        String gps =
                "{\"@type\":\"com.sundl.json.GPSData\"," +
                        "\"altitude\":26,\"correctedCourse\":45,\"course\":45,\"date\":1447665359186," +
                        "\"deviceId\":\"GPS\",\"deviceType\":\"GPS\",\"latitude\":19.658067,\"longitude\":111.117483," +
                        "\"satellitesInUse\":9,\"speed\":21,\"utc\":1447665359000}";


        CompassData compassData = JSON.parseObject(compass, CompassData.class);
        System.out.println(compassData);


        GPSData gpsData = JSON.parseObject(gps, GPSData.class);
        System.out.println(gpsData);
    }
}
