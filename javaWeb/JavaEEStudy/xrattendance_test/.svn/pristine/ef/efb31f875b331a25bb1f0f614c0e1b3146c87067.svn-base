package com.neusoft.app.controller.demo;

import com.neusoft.app.entity.demo.DemoEntity;
import com.neusoft.app.service.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by yang-jg on 2016/5/17.
 * Controller Demo
 */
@Controller
public class DemoController {
    @Autowired
    @Qualifier("demoService")
    private DemoService demoService;

    @RequestMapping(value = "/demo/demolist", method = RequestMethod.POST)
    public List<DemoEntity> getDemoList(@RequestBody DemoEntity demoEntity){
        System.out.println(demoEntity.getDemo1());
        List<DemoEntity> list=demoService.getDemoList();
        for (DemoEntity demoEntityo:list) {
            System.out.println(demoEntityo.getDemo3());
        }
        return list;
    }
}
