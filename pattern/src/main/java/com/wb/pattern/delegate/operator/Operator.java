package com.wb.pattern.delegate.operator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangbo
 * @since 2019/11/6 13:54
 */
public class Operator implements ILandline{

    private Map<String,ILandline> targets = new ConcurrentHashMap<>();

    public Operator(){
        targets.put("司令员座机",new LandLineA());
        targets.put("总部座机",new LandLineB());
    }

    @Override
    public void using(String des) {
        if(targets.containsKey(des)){
            targets.get(des).using(des);
        }
    }
}
