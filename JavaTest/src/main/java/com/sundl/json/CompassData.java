package com.sundl.json;

import java.io.Serializable;

/**
 * 罗经数据
 * @author hejz
 */
public class CompassData extends DeviceData implements Serializable{
	/**
	 * 航向 Heading Degrees - True
	 */

	private double heading;

	/**
	 * 转向速率 Rate Of Turn, degrees per minute
	 */
	private double rateOfTurn;
	

	public double getHeading() {
		return heading;
	}

	public void setHeading(double heading) {
		this.heading = heading;
	}

	public double getRateOfTurn() {
		return rateOfTurn;
	}

	public void setRateOfTurn(double rateOfTurn) {
		this.rateOfTurn = rateOfTurn;
	}

	@Override
	public String toString() {
		return "CompassData{" +
				"heading=" + heading +
				", rateOfTurn=" + rateOfTurn +
				'}';
	}
}
