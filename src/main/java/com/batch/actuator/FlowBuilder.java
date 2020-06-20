package com.batch.actuator;

import com.batch.processor.FlowProcessor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlowBuilder {

    /**
     * 执行器唯一标识
     */
    private String flowId;
    private String remark;
    private int threadNum;
    private int shardingNum;
    private SimpleAsyncTaskExecutor taskExecutor;
    private List<FlowProcessor> flowProcessorList;

    private FlowDataPartition flowDataPartition;

    public FlowBuilder(){
        flowProcessorList = new ArrayList<>();
    }

    public static FlowBuilder newBuilder(){
        return new FlowBuilder();
    }

    public void initFlowBuilder(){

    }

    public FlowBuilder addFlowProcessorList(List<FlowProcessor> processorList) {
        flowProcessorList.addAll(processorList);
        return this;
    }

    public FlowDataPartition getFlowDataPartition() {
        return flowDataPartition;
    }

    public FlowProcessor next(FlowProcessor flowProcessor){
        Optional<FlowProcessor> first = flowProcessorList.stream().filter(v -> v.getFlowSeq() >= flowProcessor.getFlowSeq()
                && !StringUtils.startsWithIgnoreCase(v.getName(), flowProcessor.getName())).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }

    public FlowProcessor firstProcessor(){
        return flowProcessorList.get(0);
    }


    /**
     * 测试processor运行
     */
    public void startProcessor(){
        firstProcessor().execute();
    }
}
