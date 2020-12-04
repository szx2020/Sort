package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 归并排序
 * 原理：先拆分 拆分 拆分  再 合并 合并 合并
 * 缺点：需要一个数组额外进行开销
 * 测试：80000个随机数 本机测试 < 1s
 *      8000000个随机数  本机测试大约 14s
 *
 * @author songzx
 * @create 2020-12-03-13:35
 */
public class MergeSort {
    public static void main(String[] args) {
        //int[] arr = {3,4,65,7,895,5,4,3};

        int[] arr = new int[80000000];
        for(int i = 0; i < 80000000; i++){
            arr[i] = (int)(Math.random()*80000000); //生成[0,80000000)的随机数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + data1Str);

        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String data2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + data2Str);

        //System.out.println("归并排序后= " + Arrays.toString(arr));
    }

    //分 + 合
    public static void mergeSort(int[] arr, int left, int right,int[] temp){
        if(left < right){
            int mid = (left + right)/2;
            //向左递归进行求解
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid + 1, right,temp);
            merge(arr,left, right,temp);
        }


    }

    //合并的方法
    /**
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param right 右边索引
     * @param temp 做中转的数组
     */
    public static void merge(int[] arr, int left, int right, int[] temp){
        int mid = (right + left) / 2 ;      //左边有序数组最后数的索引
        int i = left;  //左边有序数组开始的索引
        int j = mid + 1;   //右边有序数组开始的索引
        int t = left;      //指向temp数组的当前索引
        //先把左右两边的数据按照规则填充到temp数组
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //如果有剩余，填充到temp中
        while(i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while(j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }
        //最后注意将temp元素拷贝到arr
        //注意不是每次都拷贝整个数组，而是对应位置的数组
        for(int k = left; k <= right; k++){
            arr[k] = temp[k];
        }
    }


}