package com.zxp.controler;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxp.controler.output.BaseResponse;
import com.zxp.po.Department;
import com.zxp.service.DepartmentService;

@RestController    //@RestController = @ResponseBody + @Controller 
@RequestMapping("/dep")
public class DepartmentControler extends BaseControler{

	private static final Logger logger = Logger.getLogger(DepartmentControler.class);
	
	@Autowired
	private DepartmentService depService;
	
	@GetMapping("/getlist")
	public BaseResponse getDepList(){
		logger.info("controls  start getUserList ");
		List<Department> list = depService.selectDepartmentList();
		
		return getSuccessResponse(list);
	}
	
	/**
	 * @RequestBody 接的是json类型数据并可以恢复到对象
	 * @ModelAttribute 接的是Form表单的数据，可以恢复到对象
	 * @Validated 类型校验
	 * @PathVariable  从URL路径中获取数据
	 * @RequestHeader  从请求Header 中获取数据
	 **/
	@PostMapping("/adddep")
	public BaseResponse addDepartment(@RequestBody @Validated Department dep){
		int result = depService.addDepartment(dep);
		return getSuccessResponse(result);
	}
	
}
