package org.greencable.playground.search;

import org.greencable.playground.Solution;

/**
 * Created by wzhong on 5/25/17.
 */
public class BinarySearch implements Solution {

    private int target;

    public BinarySearch(int target) {
        this.target = target;
    }

    @Override
    public int[] run(int[] li) {
        return new int[]{ search(li, 0, li.length - 1, target) };
    }

    private int search(int[] li, int left, int right, int target) {

        if(left > right) {
            return -1;
        }

        int mid = (right + left)/2;
        if(li[mid] > target) {
            return search(li, left, mid - 1, target);
        } else if(li[mid] < target) {
            return search(li, mid + 1, right, target);
        } else {
            return mid;
        }

    }
}
