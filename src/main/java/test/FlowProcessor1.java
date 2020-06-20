package test;

import com.batch.processor.AbstractFlowProcessor;

public class FlowProcessor1 extends AbstractFlowProcessor {
    @Override
    public int getFlowSeq() {
        return 1;
    }

    @Override
    public AbstractFlowProcessor runProcessor() {
        System.out.println("flowProcessor1 run...");
        return this;
    }



    public String toString(){
        return "flowProcessor1";
    }
}
