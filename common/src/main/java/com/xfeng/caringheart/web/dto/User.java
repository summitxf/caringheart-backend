package com.xfeng.caringheart.web.dto;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * User
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-25T07:10:16.973Z")

public class User {
	private String id = null;

	private String username = null;

	private String nickname = null;

	private String email = null;

	private String password = null;

	private String phone = null;

	private String headImg = null;

	private Integer userStatus = null;

	public User id(String id) {
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

	public User username(String username) {
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

	public User nickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	/**
	 * Get nickname
	 * 
	 * @return nickname
	 **/
	@ApiModelProperty(value = "")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public User email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Get email
	 * 
	 * @return email
	 **/
	@ApiModelProperty(value = "")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User password(String password) {
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

	public User phone(String phone) {
		this.phone = phone;
		return this;
	}

	/**
	 * Get phone
	 * 
	 * @return phone
	 **/
	@ApiModelProperty(value = "")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User headImg(String headImg) {
		this.headImg = headImg;
		return this;
	}

	/**
	 * Get headImg
	 * 
	 * @return headImg
	 **/
	@ApiModelProperty(value = "")
	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public User userStatus(Integer userStatus) {
		this.userStatus = userStatus;
		return this;
	}

	/**
	 * Get userStatus
	 * 
	 * @return userStatus
	 **/
	@ApiModelProperty(value = "")
	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(this.id, user.id) && Objects.equals(this.username, user.username)
				&& Objects.equals(this.nickname, user.nickname) && Objects.equals(this.email, user.email)
				&& Objects.equals(this.password, user.password) && Objects.equals(this.phone, user.phone)
				&& Objects.equals(this.headImg, user.headImg) && Objects.equals(this.userStatus, user.userStatus);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, nickname, email, password, phone, headImg, userStatus);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class User {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    username: ").append(toIndentedString(username)).append("\n");
		sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
		sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
		sb.append("    headImg: ").append(toIndentedString(headImg)).append("\n");
		sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
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
