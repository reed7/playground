package org.greencable.playground.sort;

import org.greencable.playground.Solution;

import java.util.Arrays;

/**
 * Created by wzhong on 5/25/17.
 */
public class Merge implements Solution {
    @Override
    public int[] run(int[] li) {

        return mergeSort(li);

    }

    private int[] mergeSort(int[] li) {
        if(li.length <= 1) {
            return li;
        }

        int mid = li.length / 2;
        int[] left = Arrays.copyOfRange(li, 0, mid);
        int[] right = Arrays.copyOfRange(li, mid, li.length);

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int curr = 0, leftIdx = 0, rightIdx = 0;

        while(leftIdx < left.length && rightIdx < right.length) {
            if(left[leftIdx] < right[rightIdx]) {
                result[curr] = left[leftIdx];
                leftIdx++;
            } else {
                result[curr] = right[rightIdx];
                rightIdx++;
            }

            curr++;
        }

        if(leftIdx < left.length) {
            for(;curr < result.length;curr++) {
                result[curr] = left[leftIdx++];
            }
        }

        if(rightIdx < right.length) {
            for(;curr < result.length;curr++) {
                result[curr] = right[rightIdx++];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        int[] newArr = Arrays.copyOfRange(arr, 0, arr.length / 2);
        for(int i = 0; i < newArr.length; i++){
            System.out.print(newArr[i] + ", ");
        }
        System.out.println();

        int[] newArrr = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        for(int i = 0; i < newArrr.length; i++){
            System.out.print(newArrr[i] + ", ");
        }
        System.out.println();
    }
}
