package lby.com.research;
/*
* 二分查找
*   1、递归写法（个人比较熟悉）
*   2、迭代写法（更明了）
* */
public class BinaryResearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7, 8, 17, 18};
        int target = 7;
        System.out.println(method1(arr, 0, arr.length-1, target));
        System.out.println(method2(arr, target));
    }

    private static int method1(int[] arr, int s, int e, int target){
        if (e < s)
            return -1;
        int mid = (s + e)/2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            return method1(arr, s, mid - 1, target);
        else
            return method1(arr, mid + 1, e, target);
    }

    private static int method2(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
