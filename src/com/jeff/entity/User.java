package com.jeff.entity;

import java.util.Date;

/**
 * 
 *@description: 用户实体类	 
 *@author: Jeff
 *@date: 2019年01月19日 23:36:39
 */
public class User {
	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 登陆名
	 */
	private String loginName;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 加密盐
	 */
	private String salt;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 性别
	 */
	private Byte sex;

	/**
	 * 出生日期
	 */
	private Date birthday;

	/**
	 * 个人头像
	 */
	private String photoUrl;

	/**
	 * 用户类别:0.超级管理员 1.管理员 2.普通用户
	 */
	private Byte userType;

	/**
	 * 用户状态:0.正常 1.停用 2.已删除
	 */
	private Byte status;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 创建人
	 */
	private String createdBy;

	/**
	 * 修改时间
	 */
	private Date updateTime;

	/**
	 * 修改人
	 */
	private String updatedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Byte getUserType() {
		return userType;
	}

	public void setUserType(Byte userType) {
		this.userType = userType;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", phone=" + phone + ", email=" + email + ", password="
				+ password + ", salt=" + salt + ", nickName=" + nickName + ", name=" + name + ", sex=" + sex
				+ ", birthday=" + birthday + ", photoUrl=" + photoUrl + ", userType=" + userType + ", status=" + status
				+ ", createTime=" + createTime + ", createdBy=" + createdBy + ", updateTime=" + updateTime
				+ ", updatedBy=" + updatedBy + "]";
	}

}