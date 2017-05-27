package org.greencable.playground.sort;

import org.greencable.playground.Solution;

/**
 * Created by wzhong on 5/25/17.
 */
public class Quick implements Solution {
    @Override
    public int[] run(int[] li) {
        return quick_sort(li, 0, li.length - 1);
    }

    private int[] quick_sort(int[] li, int left, int right) {

        if(left < right) {
            int mid = arrange(li, left, right);
            li = quick_sort(li, left, mid - 1);
            li = quick_sort(li, mid + 1, right);
        }

        return li;
    }

    private int arrange(int[] li, int left, int right) {
        int pivot = li[left];

        while(left < right) {
            while(left < right && li[right] > pivot) {
                right--;
            }

            if(left < right) {
                li[left++] = li[right];
            }


            while(left < right && li[left] <= pivot) {
                left++;
            }

            if(left < right) {
                li[right--] = li[left];
            }
        }

        li[left] = pivot;

        return left;
    }

    public static void main(String[] args) {
        int[] li = {6, 20, 4, 3, 2, 9, 100, 1, 2, 3,5 ,3, 5, 3};
        new Quick().run(li);

        for(int i = 0; i < li.length; i++){
            System.out.print(li[i] + ", ");
        }
        System.out.println();
    }
}
