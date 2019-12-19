package com.zxp.controler.output;

public class BaseResponse {

	private String state;
//	private String msg;
	private Object result;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
//	public String getMsg() {
//		return msg;
//	}
//	public void setMsg(String msg) {
//		this.msg = msg;
//	}
	
	
}
