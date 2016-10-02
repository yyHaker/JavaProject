package com.neuedu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.service.kq.DataSourceServiceTest;

@Controller
public class TestControler {
	@Autowired
	@Qualifier("dataSourceServiceTest")
	private DataSourceServiceTest dataSourceServiceTest;
	@RequestMapping(value="/getAll")
	public void getAllList(){
		dataSourceServiceTest.getAllList();
		//System.out.println("********************"+map.size()+"********************");
	}

}
