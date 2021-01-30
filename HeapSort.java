package sort;

import java.util.Arrays;

import static sort.HeapSortTest.adjest;

/**
 * 堆排序
 * @author songzx
 * @create 2020-12-18-21:09
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5 ,9};
        heapSort(arr);
    }

    //写一个堆排序的方法
    public static void heapSort(int arr[]){
        //System.out.println("堆排序 ！！");
//        adjustHeap(arr,1, arr.length);
//        System.out.println( "第一次" + Arrays.toString(arr));
//
//        adjustHeap(arr, 0,arr.length);
//        System.out.println( "第二次" + Arrays.toString(arr));

        //最终代码
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            adjustHeap(arr, i ,arr.length);
        }
        //将栈顶元素与末尾元素交换，将最大元素放到数组末端，并且不操作次元素了。
        for(int j = arr.length - 1; j > 0; j--){
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     *功能：完成将以 i 对应的非叶子结点的数（这个非叶子结点的小数）调整成大顶堆
     *举例：int arr[] = {4,6,8,5,9} ; i=1 => {4,9,8,5,6}
     *继续使用 i=0 调整，得到 => {9，6，8，5，4}
     * @param arr 待调整的数组
     * @param i 表示非叶子结点在数组中的索引
     * @param length  表示对多少个元素继续调整， lenght 是在逐渐的减少
     */
    //将一个数组（二叉树），调整成一个大顶堆
    public static void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i]; //先去除当前元素的值，保存在临时变量
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1){   //i*2+1 就是左子节点
            if(k + 1 < length && arr[k] < arr[k + 1]){ //说明左子节点的值小于右子节点的值
                k++; //k指向右子结点
            }
            if(arr[k] > temp){ //如果子结点大于父结点
                arr[i] = arr[k];  //把较大的值赋给当前的结点
                i = k;   //注意！！！ i 要指向k, 继续循环比较
            }else{
                break;
            }
        }
        //当for 循环结束后 ，我们已经将以 i 为父节点的树的最大值，放在了最顶部
        arr[i] = temp; //将temp 值放在调整后的位置
    }
}
