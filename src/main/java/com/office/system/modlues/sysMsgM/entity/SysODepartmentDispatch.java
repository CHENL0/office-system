package com.office.system.modlues.sysMsgM.entity;

import com.office.system.common.baseEntity.DataEntity;

public class SysODepartmentDispatch extends DataEntity<SysODepartmentDispatch>{
	
	private String reason;
	
	private SysOUser dispatchUser;
	
	private SysODepartment oldDepartment;
	
	private SysODepartment newDeparment;
	
	private SysORole oldRole;
	
	private SysORole newRole;
	
	public SysODepartmentDispatch(){}
	
	public SysODepartmentDispatch(String id){
		
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public SysOUser getDispatchUser() {
		return dispatchUser;
	}

	public void setDispatchUser(SysOUser dispatchUser) {
		this.dispatchUser = dispatchUser;
	}

	public SysODepartment getOldDepartment() {
		return oldDepartment;
	}

	public void setOldDepartment(SysODepartment oldDepartment) {
		this.oldDepartment = oldDepartment;
	}

	public SysODepartment getNewDeparment() {
		return newDeparment;
	}

	public void setNewDeparment(SysODepartment newDeparment) {
		this.newDeparment = newDeparment;
	}

	public SysORole getOldRole() {
		return oldRole;
	}

	public void setOldRole(SysORole oldRole) {
		this.oldRole = oldRole;
	}

	public SysORole getNewRole() {
		return newRole;
	}

	public void setNewRole(SysORole newRole) {
		this.newRole = newRole;
	}
	
	

}
