package com.xfeng.caringheart.web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.joda.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;

/**
 * Heart
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-24T07:58:31.601Z")

public class Heart {
	private LocalDate groupdate = null;

	private List<HeartListData> listdata = new ArrayList<HeartListData>();

	public Heart groupdate(LocalDate groupdate) {
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

	public Heart listdata(List<HeartListData> listdata) {
		this.listdata = listdata;
		return this;
	}

	public Heart addListdataItem(HeartListData listdataItem) {
		this.listdata.add(listdataItem);
		return this;
	}

	/**
	 * Get listdata
	 * 
	 * @return listdata
	 **/
	@ApiModelProperty(value = "")
	public List<HeartListData> getListdata() {
		return listdata;
	}

	public void setListdata(List<HeartListData> listdata) {
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
		Heart heart = (Heart) o;
		return Objects.equals(this.groupdate, heart.groupdate) && Objects.equals(this.listdata, heart.listdata);
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupdate, listdata);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Heart {\n");

		sb.append("    groupdate: ").append(toIndentedString(groupdate)).append("\n");
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
