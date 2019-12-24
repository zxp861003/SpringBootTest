package com.zxp.po;

import java.io.Serializable;

public class BasePo implements Serializable{

	private static final long serialVersionUID = -6199129447030012079L;
	
	private long id;
	private String createTime;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	

}
