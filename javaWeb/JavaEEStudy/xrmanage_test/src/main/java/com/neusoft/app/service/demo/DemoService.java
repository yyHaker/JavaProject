package com.neusoft.app.service.demo;

import com.neusoft.app.entity.demo.DemoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016/5/17.
 */
public interface DemoService {
    public List<DemoEntity> getDemoList();
}
