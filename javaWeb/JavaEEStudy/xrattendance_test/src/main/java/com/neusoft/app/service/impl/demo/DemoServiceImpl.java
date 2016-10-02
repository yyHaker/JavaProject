package com.neusoft.app.service.impl.demo;

import com.neusoft.app.entity.demo.DemoEntity;
import com.neusoft.app.mapper.demo.DemoMapper;
import com.neusoft.app.service.demo.DemoService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/5/17.
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {
    @Resource
    private DemoMapper demoMapper;

    public List<DemoEntity> getDemoList() {
        return demoMapper.getDemoList();
    }
}
