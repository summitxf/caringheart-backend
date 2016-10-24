package com.xfeng.caringheart.web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.joda.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;

/**
 * Water
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-24T07:58:31.601Z")

public class Water {
	private LocalDate groupdate = null;

	private Integer groupinamount = null;

	private Integer groupoutamount = null;

	private List<WaterListData> listdata = new ArrayList<WaterListData>();

	public Water groupdate(LocalDate groupdate) {
		this.groupdate = groupdate;
		return this;
	}

	/**
	 * Get groupdate
	 * 
	 * @return groupdate
	 **/
	@ApiModelProperty(value = "")
	public LocalDate getGroupdate() {
		return groupdate;
	}

	public void setGroupdate(LocalDate groupdate) {
		this.groupdate = groupdate;
	}

	public Water groupinamount(Integer groupinamount) {
		this.groupinamount = groupinamount;
		return this;
	}

	/**
	 * Get groupinamount
	 * 
	 * @return groupinamount
	 **/
	@ApiModelProperty(value = "")
	public Integer getGroupinamount() {
		return groupinamount;
	}

	public void setGroupinamount(Integer groupinamount) {
		this.groupinamount = groupinamount;
	}

	public Water groupoutamount(Integer groupoutamount) {
		this.groupoutamount = groupoutamount;
		return this;
	}

	/**
	 * Get groupoutamount
	 * 
	 * @return groupoutamount
	 **/
	@ApiModelProperty(value = "")
	public Integer getGroupoutamount() {
		return groupoutamount;
	}

	public void setGroupoutamount(Integer groupoutamount) {
		this.groupoutamount = groupoutamount;
	}

	public Water listdata(List<WaterListData> listdata) {
		this.listdata = listdata;
		return this;
	}

	public Water addListdataItem(WaterListData listdataItem) {
		this.listdata.add(listdataItem);
		return this;
	}

	/**
	 * Get listdata
	 * 
	 * @return listdata
	 **/
	@ApiModelProperty(value = "")
	public List<WaterListData> getListdata() {
		return listdata;
	}

	public void setListdata(List<WaterListData> listdata) {
		this.listdata = listdata;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Water water = (Water) o;
		return Objects.equals(this.groupdate, water.groupdate)
				&& Objects.equals(this.groupinamount, water.groupinamount)
				&& Objects.equals(this.groupoutamount, water.groupoutamount)
				&& Objects.equals(this.listdata, water.listdata);
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupdate, groupinamount, groupoutamount, listdata);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Water {\n");

		sb.append("    groupdate: ").append(toIndentedString(groupdate)).append("\n");
		sb.append("    groupinamount: ").append(toIndentedString(groupinamount)).append("\n");
		sb.append("    groupoutamount: ").append(toIndentedString(groupoutamount)).append("\n");
		sb.append("    listdata: ").append(toIndentedString(listdata)).append("\n");
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
