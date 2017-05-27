package org.greencable.playground;

import org.greencable.playground.Solution;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wzhong on 5/25/17.
 */
public class LogTimeHandler implements InvocationHandler {

    private Solution obj;

    public LogTimeHandler(Solution obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long start = System.currentTimeMillis();
        Object ret = method.invoke(this.obj, args);
        long end = System.currentTimeMillis();
        System.out.println(this.obj.getClass().getName() + "'s run method took " + (end - start) + " milliseconds to finished!!");
        return ret;
    }
}
