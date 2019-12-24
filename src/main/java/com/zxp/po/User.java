package com.zxp.po;

import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 在SQL  XML 中可以使用别称  别称是首字母小写的类名  user
 * 
 * */
public class User extends BasePo {

	private static final long serialVersionUID = 5914805358222217754L;

	@NotBlank(message = "姓名不能为空")
	@Length(min = 2, max = 10, message = "姓名必须在2到6位之间")
	private String name;
	private byte sex;
	private int age;
	private String idCard;
	private long depId;
	private UserAccount accountInfo;
	private List<Job> jobs;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getSex() {
		return sex;
	}

	public void setSex(byte sex) {
		this.sex = sex;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public UserAccount getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(UserAccount accountInfo) {
		this.accountInfo = accountInfo;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public long getDepId() {
		return depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}

}
