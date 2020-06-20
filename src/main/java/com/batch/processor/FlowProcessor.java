package com.batch.processor;

public interface FlowProcessor extends Comparable<FlowProcessor>{



    default String getName(){
        return this.getClass().getName();
    }

    @Override
    default int compareTo(FlowProcessor flowProcessor) {
        return this.getFlowSeq() >= flowProcessor.getFlowSeq() ? 1 : -1;
    }

    int getFlowSeq();

    /**
     * 执行
     */
    void execute();
}
