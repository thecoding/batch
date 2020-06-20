package test;

import com.batch.actuator.FlowBuilder;
import com.batch.actuator.FlowContext;
import com.batch.processor.FlowProcessor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MainTest {


    public static void main(String[] args) {
        FlowProcessor1 flowProcessor1 = new FlowProcessor1();
        FlowProcessor2 flowProcessor2 = new FlowProcessor2();
        FlowProcessor3 flowProcessor3 = new FlowProcessor3();
        List<FlowProcessor> flowProcessorList = new ArrayList<>();
        flowProcessorList.add(flowProcessor3);
        flowProcessorList.add(flowProcessor1);
        flowProcessorList.add(flowProcessor2);

        Collections.sort(flowProcessorList);

        flowProcessorList.forEach(System.out::println);


        Optional<FlowProcessor> first = flowProcessorList.stream().filter(v -> v.getFlowSeq() >= flowProcessor2.getFlowSeq()
                && !StringUtils.startsWithIgnoreCase(v.getName(), flowProcessor2.getName())).findFirst();

        if (first.isPresent()) {
            System.out.println(" ------- ");
            System.out.println(first.get().toString());
        }else{
            System.out.println(" 没有找到... ");
        }

        /*******************************************/

        FlowBuilder flowBuilder = FlowBuilder.newBuilder().addFlowProcessorList(flowProcessorList);
        FlowContext.getInstance().put(flowBuilder);
        flowBuilder.startProcessor();
    }
}
