package com.sundl.shipxy;

/**
 * Created by Dennis on 2014/6/30.
 */

import javax.xml.datatype.XMLGregorianCalendar;

public class Shipxy {

    protected long mmsi;
    protected double lat;
    protected double lng;
    protected double sog;
    protected double cog;
    protected double hdg;
    protected double rot;
    protected short naviStatus;
    protected String naviStatusCn;
    protected String naviStatusEn;
    protected short shipType;
    protected String shipTypeCn;
    protected String shipTypeEn;
    protected double length;
    protected double width;
    protected double left;
    protected double trail;
    protected int imo;
    protected String callsign;
    protected String name;
    protected double draught;
    protected short month;
    protected short day;
    protected short hour;
    protected short minute;
    protected String dest;
    protected XMLGregorianCalendar lastTime;

    /**
     * Gets the value of the mmsi property.
     */
    public long getMmsi() {
        return mmsi;
    }

    /**
     * Sets the value of the mmsi property.
     */
    public void setMmsi(long value) {
        this.mmsi = value;
    }

    /**
     * Gets the value of the lat property.
     */
    public double getLat() {
        return lat;
    }

    /**
     * Sets the value of the lat property.
     */
    public void setLat(double value) {
        this.lat = value;
    }

    /**
     * Gets the value of the lng property.
     */
    public double getLng() {
        return lng;
    }

    /**
     * Sets the value of the lng property.
     */
    public void setLng(double value) {
        this.lng = value;
    }

    /**
     * Gets the value of the sog property.
     */
    public double getSog() {
        return sog;
    }

    /**
     * Sets the value of the sog property.
     */
    public void setSog(double value) {
        this.sog = value;
    }

    /**
     * Gets the value of the cog property.
     */
    public double getCog() {
        return cog;
    }

    /**
     * Sets the value of the cog property.
     */
    public void setCog(double value) {
        this.cog = value;
    }

    /**
     * Gets the value of the hdg property.
     */
    public double getHdg() {
        return hdg;
    }

    /**
     * Sets the value of the hdg property.
     */
    public void setHdg(double value) {
        this.hdg = value;
    }

    /**
     * Gets the value of the rot property.
     */
    public double getRot() {
        return rot;
    }

    /**
     * Sets the value of the rot property.
     */
    public void setRot(double value) {
        this.rot = value;
    }

    /**
     * Gets the value of the naviStatus property.
     */
    public short getNaviStatus() {
        return naviStatus;
    }

    /**
     * Sets the value of the naviStatus property.
     */
    public void setNaviStatus(short value) {
        this.naviStatus = value;
    }

    /**
     * Gets the value of the naviStatusCn property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNaviStatusCn() {
        return naviStatusCn;
    }

    /**
     * Sets the value of the naviStatusCn property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNaviStatusCn(String value) {
        this.naviStatusCn = value;
    }

    /**
     * Gets the value of the naviStatusEn property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNaviStatusEn() {
        return naviStatusEn;
    }

    /**
     * Sets the value of the naviStatusEn property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNaviStatusEn(String value) {
        this.naviStatusEn = value;
    }

    /**
     * Gets the value of the shipType property.
     */
    public short getShipType() {
        return shipType;
    }

    /**
     * Sets the value of the shipType property.
     */
    public void setShipType(short value) {
        this.shipType = value;
    }

    /**
     * Gets the value of the shipTypeCn property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getShipTypeCn() {
        return shipTypeCn;
    }

    /**
     * Sets the value of the shipTypeCn property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setShipTypeCn(String value) {
        this.shipTypeCn = value;
    }

    /**
     * Gets the value of the shipTypeEn property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getShipTypeEn() {
        return shipTypeEn;
    }

    /**
     * Sets the value of the shipTypeEn property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setShipTypeEn(String value) {
        this.shipTypeEn = value;
    }

    /**
     * Gets the value of the length property.
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     */
    public void setLength(double value) {
        this.length = value;
    }

    /**
     * Gets the value of the width property.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     */
    public void setWidth(double value) {
        this.width = value;
    }

    /**
     * Gets the value of the left property.
     */
    public double getLeft() {
        return left;
    }

    /**
     * Sets the value of the left property.
     */
    public void setLeft(double value) {
        this.left = value;
    }

    /**
     * Gets the value of the trail property.
     */
    public double getTrail() {
        return trail;
    }

    /**
     * Sets the value of the trail property.
     */
    public void setTrail(double value) {
        this.trail = value;
    }

    /**
     * Gets the value of the imo property.
     */
    public int getImo() {
        return imo;
    }

    /**
     * Sets the value of the imo property.
     */
    public void setImo(int value) {
        this.imo = value;
    }

    /**
     * Gets the value of the callsign property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCallsign() {
        return callsign;
    }

    /**
     * Sets the value of the callsign property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCallsign(String value) {
        this.callsign = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the draught property.
     */
    public double getDraught() {
        return draught;
    }

    /**
     * Sets the value of the draught property.
     */
    public void setDraught(double value) {
        this.draught = value;
    }

    /**
     * Gets the value of the month property.
     */
    public short getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     */
    public void setMonth(short value) {
        this.month = value;
    }

    /**
     * Gets the value of the day property.
     */
    public short getDay() {
        return day;
    }

    /**
     * Sets the value of the day property.
     */
    public void setDay(short value) {
        this.day = value;
    }

    /**
     * Gets the value of the hour property.
     */
    public short getHour() {
        return hour;
    }

    /**
     * Sets the value of the hour property.
     */
    public void setHour(short value) {
        this.hour = value;
    }

    /**
     * Gets the value of the minute property.
     */
    public short getMinute() {
        return minute;
    }

    /**
     * Sets the value of the minute property.
     */
    public void setMinute(short value) {
        this.minute = value;
    }

    /**
     * Gets the value of the dest property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDest() {
        return dest;
    }

    /**
     * Sets the value of the dest property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDest(String value) {
        this.dest = value;
    }

    /**
     * Gets the value of the lastTime property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getLastTime() {
        return lastTime;
    }

    /**
     * Sets the value of the lastTime property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setLastTime(XMLGregorianCalendar value) {
        this.lastTime = value;
    }

}