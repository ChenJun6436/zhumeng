package com.jf.projects.zmt.vo.inspection;

import com.jf.projects.zmt.vo.account.AddUserInfoVo;

public class AddInspectionUser extends AddUserInfoVo {
	/**
	 * 检疫中心名字
	 */
	private String inspectionName;
	/**
	 * 检疫中心id
	 */
	private String inspectionId;

	public AddInspectionUser() {
		super();
	}

	public String getInspectionId() {
		return inspectionId;
	}

	public void setInspectionId(String inspectionId) {
		this.inspectionId = inspectionId;
	}

	public String getInspectionName() {
		return inspectionName;
	}

	public void setInspectionName(String inspectionName) {
		this.inspectionName = inspectionName;
	}

}
