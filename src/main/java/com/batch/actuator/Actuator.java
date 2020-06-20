package com.batch.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * 总的执行引擎
 */
@Component
public class Actuator {

    @Autowired
    LocateResolve locateResolve;

    public void execute(String flowId) {
        FlowBuilder flowBuilder = locateResolve.getFlowBuilder(flowId);
        //分区
        Map<String, Object> stringObjectMap = flowBuilder.getFlowDataPartition().doPartition();


    }
}
