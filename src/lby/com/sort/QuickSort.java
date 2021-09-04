package lby.com.sort;

import java.util.Arrays;
/*
* 快速排序
* 思想: 主要基于分治 + 递归
* 理解: 1 参考图解算法中的解释
*      2 自己:
*       找一个基准(一般是首位置元素)
*       找到基准在原始数组的绝对位置,然后构造左右数组(通过下标伪构造,所有操作都在原始数组上完成)
*       其左数组都是比基准小的,其右数组都是别基准大的
*       再对左右两个数组进行同样的操作
*
* */
public class QuickSort{
    public int[] sort(int[] sourceArray){
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(array, 0, array.length-1);
    }

    private int[] quickSort(int[] arr, int left, int right){
        if (right > left){
            int partitionIndex = partition(arr, left, right);
//            printArr(arr);
            quickSort(arr, left, partitionIndex-1);
            quickSort(arr, partitionIndex+1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right){
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]){
                //注意此次是交换i和index位置的元素！pivot在循环中不动！
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index-1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void printArr(int[] arr){
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }
}
