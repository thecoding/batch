package com.batch.processor;

import com.batch.actuator.FlowBuilder;
import com.batch.actuator.FlowContext;

public abstract class AbstractFlowProcessor implements FlowProcessor{

    @Override
    public void execute() {
        runProcessor().next();
    }

    public AbstractFlowProcessor runProcessor(){
        return this;
    }
    
    
    private void next(){
        FlowBuilder flowBuilder = FlowContext.getInstance().get(FlowBuilder.class);
        FlowProcessor nextFlowProcessor = flowBuilder.nextProcessor(this);
        if (nextFlowProcessor != null) {
            nextFlowProcessor.execute();
        }

    }

}
