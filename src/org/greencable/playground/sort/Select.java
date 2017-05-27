package org.greencable.playground.sort;

import org.greencable.playground.Solution;

/**
 * Created by wzhong on 5/25/17.
 */
public class Select implements Solution {
    @Override
    public int[] run(int[] li) {
        for(int i = 0;i < li.length;i++) {
            int min_idx = i;
            for(int j = i;j < li.length;j++) {
                if(li[j] < li[min_idx]) {
                    min_idx = j;
                }
            }

            int tmp = li[i];
            li[i] = li[min_idx];
            li[min_idx] = tmp;
        }

        return li;
    }
}
