package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 快速排序
 * 原理：将第一个元素设置为标准，小于标准的放左边，大于标准的放右边，递归求解
 * 测试：80000个随机数 本机测试  < 1s
 *      800000个随机数 本机测试  < 1s
 *      8000000个随机数 本机测试  1s
 *      80000000个随机数 本机测试  11s
 * @author songzx
 * @create 2020-12-02-22:33
 */
public class QuickSort {
    public static void main(String[] args) {
        //int[] arr = {3,4,6,7,2,7,2,8,0,645,232,43,56,34,75,24};

        int[] arr = new int[80000000];
        for(int i = 0; i < 80000000; i++){
            arr[i] = (int)(Math.random()*80000000); //生成[0,80000000)的随机数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + data1Str);

        quickSort(arr,0,arr.length - 1);

        Date data2 = new Date();
        String data2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + data2Str);
        //System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int start,int end){
        if(start < end){
            int pivot = arr[start];
            int low = start;
            int high = end;
            while(low < high){
                //为什么要在下面的while循环里加low < high？
                //因为对low high进行操作完循环才会判断是否“<” ,会出错
                while(low < high && arr[high] >= pivot){
                    high--;
                }
                arr[low] = arr[high];
                while(low < high && arr[low] <= pivot){
                    low++;
                }
                arr[high] = arr[low];
            }
            //此时low == high
            arr[low] = pivot;

            quickSort(arr,start,low);
            quickSort(arr,low + 1, end);
        }
        }
}
