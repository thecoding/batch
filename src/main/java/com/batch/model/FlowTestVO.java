package com.batch.model;

public class FlowTestVO {

    private String flowId;
    private String name;

    public FlowTestVO() {
    }

    public FlowTestVO(String flowId, String name) {
        this.flowId = flowId;
        this.name = name;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FlowResult{" +
                "flowId='" + flowId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
