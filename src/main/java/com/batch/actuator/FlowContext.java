package com.batch.actuator;

import com.batch.model.FlowTestVO;

import java.util.HashMap;
import java.util.Map;

public class FlowContext {

    ThreadLocal<Map<String, Object>> flowContext = ThreadLocal.withInitial(HashMap::new);


    private FlowContext(){

    }

    public enum FlowContextHandler {
        _instance;
        private FlowContext context = new FlowContext();
    }


    public static FlowContext getInstance() {
        return FlowContextHandler._instance.context;
    }

    public void put(String key, Object object) {
        flowContext.get().put(key,object);
    }

    public void put(Object object) {
//        if (object != null && !flowContext.get().containsKey(object.getClass().getSimpleName())) {
////            put(object.getClass().getSimpleName(), object);
//        }
        put(object.getClass().getSimpleName(), object);
    }

    public <T> T get(Class<T> cls) {
        return (T) flowContext.get().get(cls.getSimpleName());
    }

    public <T> T get(String key, Class<?> cls) {
        return  (T) cls.cast(flowContext.get().get(key));
    }


    public static void main(String[] args) {
        FlowTestVO flowResult = new FlowTestVO("test1", "result");
        FlowContext.getInstance().put(flowResult);

        FlowTestVO result = FlowContext.getInstance().get(FlowTestVO.class);
        System.out.println(result.toString());

        FlowTestVO result1 = FlowContext.getInstance().get(FlowTestVO.class.getSimpleName(), FlowTestVO.class);
        System.out.println(result1);
    }
}
