package com.zxp.po;

public class Job extends BasePo{

	private static final long serialVersionUID = 1L;
	private long userId;
	private String jobName;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
}
