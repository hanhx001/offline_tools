package com.hhx.offline_tools.gee100;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalTest {
    private static final  ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(()->null);

    private Map right(Integer userId){
        String before = Thread.currentThread().getName()+":"+currentUser.get();
        currentUser.set(userId);

        try {
            String after = Thread.currentThread().getName()+":"+currentUser.get();
            Map result = new HashMap();
            result.put("before",before);
            result.put("after",after);
            return result;
        }finally {
            // 在finall代码块中删除ThreadLOcal中的数据，却波啊数据不串
            currentUser.remove();
        }
    }
}
