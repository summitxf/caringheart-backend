package com.xfeng.caringheart.web.model;

import java.util.Objects;

import org.joda.time.DateTime;

import io.swagger.annotations.ApiModelProperty;

/**
 * WaterListData
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-24T07:58:31.601Z")

public class WaterListData {
	private String id = null;

	private DateTime date = null;

	private String type = null;

	private Integer amount = null;

	public WaterListData id(String id) {
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

	public WaterListData date(DateTime date) {
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

	public WaterListData type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Get type
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public WaterListData amount(Integer amount) {
		this.amount = amount;
		return this;
	}

	/**
	 * Get amount
	 * 
	 * @return amount
	 **/
	@ApiModelProperty(value = "")
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		WaterListData waterListData = (WaterListData) o;
		return Objects.equals(this.id, waterListData.id) && Objects.equals(this.date, waterListData.date)
				&& Objects.equals(this.type, waterListData.type) && Objects.equals(this.amount, waterListData.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, date, type, amount);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class WaterListData {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    date: ").append(toIndentedString(date)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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
