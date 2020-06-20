package test;

import com.batch.processor.AbstractFlowProcessor;

public class FlowProcessor2 extends AbstractFlowProcessor{
    @Override
    public int getFlowSeq() {
        return 2;
    }

    @Override
    public AbstractFlowProcessor runProcessor() {
        System.out.println("flowProcessor2 run...");
        return this;
    }

    public String toString(){
        return "flowProcessor2";
    }
}
