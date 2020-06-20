package test;

import com.batch.processor.AbstractFlowProcessor;

public class FlowProcessor4 extends AbstractFlowProcessor {
    @Override
    public int getFlowSeq() {
        return 4;
    }

    @Override
    public AbstractFlowProcessor runProcessor() {
        System.out.println("flowProcessor4 run...");
        return this;
    }

    public String toString(){
        return "flowProcessor4";
    }
}
