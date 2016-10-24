package com.xfeng.caringheart.web.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResultMsg
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-24T07:58:31.601Z")

public class ResultMsg {
	private String code = null;

	private String msg = null;

	public ResultMsg code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Get code
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ResultMsg msg(String msg) {
		this.msg = msg;
		return this;
	}

	/**
	 * Get msg
	 * 
	 * @return msg
	 **/
	@ApiModelProperty(value = "")
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResultMsg resultMsg = (ResultMsg) o;
		return Objects.equals(this.code, resultMsg.code) && Objects.equals(this.msg, resultMsg.msg);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, msg);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResultMsg {\n");

		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
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
