package com.zxp.controler;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController //表示该类下的方法返回值会被自动做json格式的转换
public class FileUploadControler {

	@RequestMapping("/fileUpload")
	public Map<String, Object> fileUpload(MultipartFile fileName) throws IllegalStateException, IOException{
		fileName.transferTo(new File("e:/"+fileName.getOriginalFilename()));
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "HelloWorld");
		System.out.println(fileName.getName());
		return map;
	}
}
