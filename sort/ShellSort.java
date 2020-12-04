package com.atguigu.sort;

import java.util.Arrays;

/**
 * 希尔排序，解决插入排序小数在后面移到前面会导致移动的次数过多问题
 * 原理是分组排序，先二分再二分
 * @author songzx
 * @create 2020-12-02-19:44
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
        //System.out.println(Arrays.toString(arr));

    }

    //希尔排序，从小到大
    public static void shellSort(int[] arr){

        for(int gap = arr.length/2; gap > 0; gap = gap/2 ){
            //以下采用插入排序方法
            for(int i = gap; i < arr.length ; i++){
                int insertIndex = i - gap;
                int insertVal = arr[i];
                while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex = insertIndex - gap;
                }
                arr[insertIndex + gap] = insertVal;

            }
            System.out.println(Arrays.toString(arr));
        }

    }
}

