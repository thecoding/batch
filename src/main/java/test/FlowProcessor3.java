package test;

import com.batch.processor.AbstractFlowProcessor;

public class FlowProcessor3 extends AbstractFlowProcessor {
    @Override
    public int getFlowSeq() {
        return 3;
    }

    @Override
    public AbstractFlowProcessor runProcessor() {
        System.out.println("flowProcessor3 run...");
        return this;
    }


    public String toString(){
        return "flowProcessor3";
    }
}
