package com.batch.actuator;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Locate implements LocateResolve{


    /**
     * 初始化获取所有builder
     */
    @PostConstruct
    public void initLocate(){

    }


    @Override
    public FlowBuilder getFlowBuilder(String flowId) {
        return null;
    }
}
