package com.xfeng.caringheart.web.entity;

import org.joda.time.DateTime;

public class HeartEntity {

	private String id = null;

	private DateTime date = null;

	private Integer low = null;

	private Integer high = null;

	private Integer heartbeat = null;

	private Double weight = null;

	private String userid = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public Integer getLow() {
		return low;
	}

	public void setLow(Integer low) {
		this.low = low;
	}

	public Integer getHigh() {
		return high;
	}

	public void setHigh(Integer high) {
		this.high = high;
	}

	public Integer getHeartbeat() {
		return heartbeat;
	}

	public void setHeartbeat(Integer heartbeat) {
		this.heartbeat = heartbeat;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
