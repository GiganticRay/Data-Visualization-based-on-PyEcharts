package edu.cuit.gcsj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;

import edu.cuit.gcsj.po.BrokenLine;
import edu.cuit.gcsj.service.ISaleService;

@Controller
public class Controllerer {
	@Autowired
	private ISaleService service;
	@ResponseBody
	@RequestMapping("/1.action")
	public Object listSales1() {

		
		return service.selectSY7();


	}

}