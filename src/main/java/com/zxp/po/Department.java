package com.zxp.po;

public class Department extends BasePo{

	private static final long serialVersionUID = 8229553158584640148L;

	private String name;
	private long parentId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
}
