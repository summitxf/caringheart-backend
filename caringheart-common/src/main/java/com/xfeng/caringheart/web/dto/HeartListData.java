package com.xfeng.caringheart.web.dto;

import java.util.Objects;

import org.joda.time.DateTime;

import io.swagger.annotations.ApiModelProperty;

/**
 * HeartListData
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-24T07:58:31.601Z")

public class HeartListData {
	
	private String id = null;

	private DateTime date = null;

	private Integer low = null;

	private Integer high = null;

	private Integer heartbeat = null;

	private Double weight = null;

	public HeartListData id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HeartListData date(DateTime date) {
		this.date = date;
		return this;
	}

	/**
	 * Get date
	 * 
	 * @return date
	 **/
	@ApiModelProperty(value = "")
	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public HeartListData low(Integer low) {
		this.low = low;
		return this;
	}

	/**
	 * Get low
	 * 
	 * @return low
	 **/
	@ApiModelProperty(value = "")
	public Integer getLow() {
		return low;
	}

	public void setLow(Integer low) {
		this.low = low;
	}

	public HeartListData high(Integer high) {
		this.high = high;
		return this;
	}

	/**
	 * Get high
	 * 
	 * @return high
	 **/
	@ApiModelProperty(value = "")
	public Integer getHigh() {
		return high;
	}

	public void setHigh(Integer high) {
		this.high = high;
	}

	public HeartListData heartbeat(Integer heartbeat) {
		this.heartbeat = heartbeat;
		return this;
	}

	/**
	 * Get heartbeat
	 * 
	 * @return heartbeat
	 **/
	@ApiModelProperty(value = "")
	public Integer getHeartbeat() {
		return heartbeat;
	}

	public void setHeartbeat(Integer heartbeat) {
		this.heartbeat = heartbeat;
	}

	public HeartListData weight(Double weight) {
		this.weight = weight;
		return this;
	}

	/**
	 * Get weight
	 * 
	 * @return weight
	 **/
	@ApiModelProperty(value = "")
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HeartListData heartListData = (HeartListData) o;
		return Objects.equals(this.id, heartListData.id) && Objects.equals(this.date, heartListData.date)
				&& Objects.equals(this.low, heartListData.low) && Objects.equals(this.high, heartListData.high)
				&& Objects.equals(this.heartbeat, heartListData.heartbeat)
				&& Objects.equals(this.weight, heartListData.weight);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, date, low, high, heartbeat, weight);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class HeartListData {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    date: ").append(toIndentedString(date)).append("\n");
		sb.append("    low: ").append(toIndentedString(low)).append("\n");
		sb.append("    high: ").append(toIndentedString(high)).append("\n");
		sb.append("    heartbeat: ").append(toIndentedString(heartbeat)).append("\n");
		sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
