package org.greencable.playground;

import org.greencable.playground.search.BinarySearch;
import org.greencable.playground.sort.*;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by wzhong on 5/24/17.
 */
public class Play {

    public static void main(String[] args) {
        //printArr(arr);

        Solution insert = new Insert();
        Solution shell = new Shell();
        Solution select = new Select();
        Solution bubble = new Bubble();
        Solution merge = new Merge();
        Solution quick = new Quick();

        Solution insertProxy = (Solution)Proxy.newProxyInstance(insert.getClass().getClassLoader(),
                new Class[]{ Solution.class }, new LogTimeHandler(insert));
        Solution shellProxy = (Solution)Proxy.newProxyInstance(insert.getClass().getClassLoader(),
                new Class[]{ Solution.class }, new LogTimeHandler(shell));
        Solution selectProxy = (Solution)Proxy.newProxyInstance(insert.getClass().getClassLoader(),
                new Class[]{ Solution.class }, new LogTimeHandler(select));
        Solution bubbleProxy = (Solution)Proxy.newProxyInstance(insert.getClass().getClassLoader(),
                new Class[]{ Solution.class }, new LogTimeHandler(bubble));
        Solution mergeProxy = (Solution)Proxy.newProxyInstance(insert.getClass().getClassLoader(),
                new Class[]{ Solution.class }, new LogTimeHandler(merge));
        Solution quickProxy = (Solution)Proxy.newProxyInstance(insert.getClass().getClassLoader(),
                new Class[]{ Solution.class }, new LogTimeHandler(quick));

        int len = 100000000;

        int[] arr = generateArr(len);

        int[] dummyArr = Arrays.copyOf(arr, arr.length);
        //insertProxy.run(dummyArr);

        dummyArr = Arrays.copyOf(arr, arr.length);
        //shellProxy.run(dummyArr);

        dummyArr = Arrays.copyOf(arr, arr.length);
        //selectProxy.run(dummyArr);

        dummyArr = Arrays.copyOf(arr, arr.length);
        //bubbleProxy.run(dummyArr);

        dummyArr = Arrays.copyOf(arr, arr.length);
        //mergeProxy.run(dummyArr);

        dummyArr = Arrays.copyOf(arr, arr.length);
        dummyArr = quickProxy.run(dummyArr);

        // Search
        Solution bSearch = new BinarySearch(dummyArr[100000]);
        Solution bSearchProxy = (Solution)Proxy.newProxyInstance(insert.getClass().getClassLoader(),
                new Class[]{ Solution.class }, new LogTimeHandler(bSearch));

        System.out.println(bSearchProxy.run(dummyArr)[0]);
    }

    private static int[] generateArr(int len) {
        int[] a = new int[len];
        Random r = new Random();
        for(int i = 0;i < a.length;i++) {
            a[i] = r.nextInt(len * 100);
        }

        return a;
    }

    private static void printArr(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
