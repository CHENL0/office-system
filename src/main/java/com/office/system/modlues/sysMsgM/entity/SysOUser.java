package com.office.system.modlues.sysMsgM.entity;

import com.office.system.common.baseEntity.DataEntity;

public class  SysOUser extends DataEntity<SysOUser> {
	
	private String loginName;//登录名
	
	private String name;//姓名
	
	private String no;//工号
	
	private String photo;//头像
	
/*	private String oldPassword;//旧密码
	
	private String newPassword;//新密码
	
*/	
	private String password;
	
	private String email;//邮箱
	
	private String phone;//电话
	
	private String adress;//地址
	
	private SysORole sysORole;//角色
	
	private String sex;
	
	private SysODepartment sysODepartment;//部门
	
//	private Email email;
//	
//
//	public Email getEmail() {
//		return email;
//	}
//
//	public void setEmail(Email email) {
//		this.email = email;
//	}

	public SysOUser(){
	}
	public SysOUser(String id){
		
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

//	public String getOldPassword() {
//		return oldPassword;
//	}
//
//	public void setOldPassword(String oldPassword) {
//		this.oldPassword = oldPassword;
//	}
//
//	public String getNewPassword() {
//		return newPassword;
//	}
//
//	public void setNewPassword(String newPassword) {
//		this.newPassword = newPassword;
//	}

/*	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}*/

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SysORole getSysORole() {
		return sysORole;
	}
	public void setSysORole(SysORole sysORole) {
		this.sysORole = sysORole;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public SysODepartment getSysODepartment() {
		return sysODepartment;
	}
	public void setSysODepartment(SysODepartment sysODepartment) {
		this.sysODepartment = sysODepartment;
	}
	

}
