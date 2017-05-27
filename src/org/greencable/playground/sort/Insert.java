package org.greencable.playground.sort;

import org.greencable.playground.Solution;

/**
 * Created by wzhong on 5/25/17.
 */
public class Insert implements Solution {

    public int[] run(int[] li) {
        for(int j = 1;j < li.length;j++) {
            if(li[j] < li[j - 1]) {
                int tmp = li[j];
                li[j] = li[j - 1];
                li[j - 1] = tmp;

                int k = j - 1;
                while(k > 0 && li[k - 1] > tmp) {
                    li[k] = li[k - 1];
                    k--;
                }

                li[k] = tmp;
            }
        }

        return li;
    }

}
