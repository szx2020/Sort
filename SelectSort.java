package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 实现选择排序
 * 思路：从后面的数组里找出最小的数放到最前面
 * 说明：找最小的数时不进行交换,最小的数与前面有序的数的末尾进行交换
 * 测试：80000个数本机测试大约 3s
 * @author songzx
 * @create 2020-11-30-17:05
 */
public class SelectSort {
    public static void main(String[] args) {
        //int[] arr = {3, 5, 9, 7, 2};

        int[] arr = new int[80000];
        for(int i = 0; i < 80000; i++){
            arr[i] = (int)(Math.random()*80000); //生成[0,80000)的随机数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + data1Str);

        selectSort(arr);

        Date data2 = new Date();
        String data2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + data2Str);
        //System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static  void selectSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = arr[i];
            int min_index = i;
            for(int j = i; j < arr.length; j++){
                if(min > arr[j]){
                    min = arr[j];
                    min_index = j;
                }
            }
            arr[min_index] = arr[i];
            arr[i] = min;
        }

    }

}
