package com.zxp.controler;

import com.zxp.controler.output.BaseResponse;

public class BaseControler {

	
	public BaseResponse getSuccessResponse(Object result){
		BaseResponse response = new BaseResponse();
		response.setState("success");
		response.setResult(result);
		return response;
	}
	
	public BaseResponse getFailResponse(String msg){
		BaseResponse response = new BaseResponse();
		response.setState("fail");
		response.setResult(msg);
//		response.setMsg(msg);
		return response;
	}
}
