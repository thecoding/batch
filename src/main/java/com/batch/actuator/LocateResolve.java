package com.batch.actuator;

public interface LocateResolve {

    /**
     * 通过flowId获取Builder
     * @param flowId
     * @return
     */
    FlowBuilder getFlowBuilder(String flowId);
}
