package com.sundl.json;

import java.io.Serializable;
import java.util.Date;

/**
 * GPS数据
 *
 * @author hejz
 */
public class GPSData extends DeviceData implements Serializable {

    private static final long serialVersionUID = 3L;
    /**
     * UTC 世界调整时间（Universal Time Coordinated）
     */
    private Date utc;

    /**
     * 经度 RMC.Longitude, GGA.Longitude
     */
    private double longitude;

    /**
     * 纬度 RMC.Latitude, GGA.Latitude
     */
    private double latitude;

    /**
     * 高度 GGA.Altitude (Antenna Altitude above/below mean-sea-level (geoid))
     */
    private double altitude;

    /**
     * 地面速度RMC.Speed( Speed over ground, knots)
     */
    private double speed;

    /**
     * 航向 RMC.Course( Track made good, degrees true )
     */
    private double course;

    /**
     * 矫正的航向 RMC.Course, RMC.Variation
     */
    private double correctedCourse;

    /**
     * 正在使用的卫星个数 GGA.SatellitesInUse
     */
    private int satellitesInUse;

    public Date getUtc() {
        return utc;
    }

    public void setUtc(Date utc) {
        this.utc = utc;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    public double getCorrectedCourse() {
        return correctedCourse;
    }

    public void setCorrectedCourse(double correctedCourse) {
        this.correctedCourse = correctedCourse;
    }

    public int getSatellitesInUse() {
        return satellitesInUse;
    }

    public void setSatellitesInUse(int satellitesInUse) {
        this.satellitesInUse = satellitesInUse;
    }

    // @Override
    // public String toString() {
    // return String.format("UTC=%s, RMC=%b, GGA=%b, ZDA=%b",
    // DateUtils.date2str(UTC), hasRMC, hasGGA, hasZDA);
    // }
}
