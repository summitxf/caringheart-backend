package com.xfeng.caringheart.web.dto;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * UserPwd
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-25T07:10:16.973Z")

public class UserPwd {
	private String username = null;

	private String password = null;

	private String newpassword = null;

	public UserPwd username(String username) {
		this.username = username;
		return this;
	}

	/**
	 * Get username
	 * 
	 * @return username
	 **/
	@ApiModelProperty(value = "")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserPwd password(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Get password
	 * 
	 * @return password
	 **/
	@ApiModelProperty(value = "")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserPwd newpassword(String newpassword) {
		this.newpassword = newpassword;
		return this;
	}

	/**
	 * Get newpassword
	 * 
	 * @return newpassword
	 **/
	@ApiModelProperty(value = "")
	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserPwd userPwd = (UserPwd) o;
		return Objects.equals(this.username, userPwd.username) && Objects.equals(this.password, userPwd.password)
				&& Objects.equals(this.newpassword, userPwd.newpassword);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, password, newpassword);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class UserPwd {\n");

		sb.append("    username: ").append(toIndentedString(username)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
		sb.append("    newpassword: ").append(toIndentedString(newpassword)).append("\n");
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
