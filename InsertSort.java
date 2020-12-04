package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 实现插入排序
 * 原理；将数组前面看成有序数组，然后后面的元素依次加入这个有序数组
 * 测试；80000个随机数进行测试，本机大约 1s
 *      800000个数进行测试，本机大约 72 s
 *
 * @author songzx
 * @create 2020-12-02-19:25
 */
public class InsertSort {
    public static void main(String[] args) {
        //int[] arr = {4,6,3,2,7};

        int[] arr = new int[800000];
        for(int i = 0; i < 800000; i++){
            arr[i] = (int)(Math.random()*800000); //生成[0,800000)的随机数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + data1Str);

        insertSort(arr);

        Date data2 = new Date();
        String data2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + data2Str);

        //System.out.println(Arrays.toString(arr));
    }

    //插入排序方法
    public static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int insertIndex = i - 1;  //插入的位置
            int insertVal = arr[i];  //要加入顺序数组的数

            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }
}
