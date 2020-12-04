package com.atguigu.sort;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 实现冒泡排序，时间复杂度 O(n^2)
 * 原理：遍历数组，每一次遍历两两相比将最大的挪到最后
 * 优化方式：设置一个flag标志，如果当循环没有进行数据交换，停止
 *          第二层没必要循环到最后，到第一层的结束就行了。
 * 测试：80000个随机数进行测试，本机大约 16 s
 * @author songzx
 * @create 2020-11-30-15:21
 */
public class BubbleSort {
    public static void main(String[] args) {

//        int[] arr = {3, 9, -1 ,10, 20};
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));

        //测试一下冒泡排序的速度O(n^2),给80000个数据，测试
        //设置一个80000个随机的数组
        int[] arr = new int[80000];
        for(int i = 0; i < 80000; i++){
            arr[i] = (int)(Math.random()*80000); //生成[0,80000)的随机数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + data1Str);

        bubbleSort(arr);

        Date data2 = new Date();
        String data2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + data2Str);

//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));


    }

    //写一个冒泡排序的方法
    public static void bubbleSort(int[] arr){
        int temp = 0; //设置交换的变量
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1; j++){
                //如果前面的数比后面的数大则交换
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1]  = temp;
                }
            }
        }
    }
}
