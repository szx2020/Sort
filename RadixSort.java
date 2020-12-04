package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 基数排序
 * 原理：设置十个桶，先按个位数放进桶，然后取出：再按十位数放进桶，然后取出；直至最高位数，取出就排序好了
 * 测试：80000个随机数 ，本机测试 < 1 s
 *       800000个随机数 ， 本机测试  < 1s
 *       8000000个随机数， 本机测试 2s
 *       80000000个随机数， 本机测试 内存溢出 OutOfMemoryError
 * @author songzx
 * @create 2020-12-03-19:22
 */
public class RadixSort {
    public static void main(String[] args) {
        //int[] arr = {34,67,356,896,55,7,98,34,56,76,87,333,467,899};

        int[] arr = new int[8000000];
        for(int i = 0; i < 8000000; i++){
            arr[i] = (int)(Math.random()*8000000); //生成[0,8000000)的随机数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + data1Str);

        radixSort(arr);

        Date data2 = new Date();
        String data2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + data2Str);

        //System.out.println(Arrays.toString(arr));

    }

    public static void radixSort(int arr[]){
        //先寻找出最大的元素
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //计算需要循环的次数
        int cycleNum = (max+"").length(); //将其转换成字符串再利用方法

        for(int c = 0; c < cycleNum; c++){
            int[][] bucket = new int[10][arr.length];
            int[] bucketIndex = new int[10];
            for(int i = 0; i < arr.length; i++){
                int temp = (int)(arr[i] / (Math.pow(10,c))); //强制转换成整形
                int index = temp % 10;  //得到这个数的个/十/百位数
                bucket[index][bucketIndex[index]] = arr[i];   //把这个个/ / 位数放进对应的数组里
                bucketIndex[index] ++;  //记录这个桶中的元素
            }
            //按照桶的顺序，遍历桶中数据，放入到原数组中
            int index = 0;
            for(int k = 0; k < bucketIndex.length; k++){
                if(bucketIndex[k] != 0){
                    for(int l = 0; l < bucketIndex[k]; l++){
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                bucketIndex[k] = 0;
            }
        }
    }



}
