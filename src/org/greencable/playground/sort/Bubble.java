package org.greencable.playground.sort;

import org.greencable.playground.Solution;

/**
 * Created by wzhong on 5/25/17.
 */
public class Bubble implements Solution {
    @Override
    public int[] run(int[] li) {
        boolean swapped = true;

        for(int i = li.length - 1; i >= 0; i--) {
            if(swapped) {
                swapped = false;
                for (int j = 0; j < i; j++) {
                    if (li[j] > li[j + 1]) {
                        int tmp = li[j + 1];
                        li[j + 1] = li[j];
                        li[j] = tmp;
                        swapped = true;
                    }
                }
            } else {
                break;
            }
        }

        return li;
    }
}
