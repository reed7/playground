package org.greencable.playground.sort;

import org.greencable.playground.Solution;

/**
 * Created by wzhong on 5/25/17.
 */
public class Shell implements Solution {
    @Override
    public int[] run(int[] li) {
        for(int gap = li.length/2; gap > 0; gap /= 2) {
            for(int j = gap;j < li.length; j += gap) {
                if(li[j] < li[j - gap]) {
                    int tmp = li[j];
                    li[j] = li[j - gap];
                    li[j - gap] = tmp;

                    int k = j - gap;
                    while(k > 0 && li[k - gap] > tmp) {
                        li[k] = li[k - gap];
                        k -= gap;
                    }

                    li[k] = tmp;
                }
            }
        }

        return li;
    }
}
