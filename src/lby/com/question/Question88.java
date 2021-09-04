package lby.com.question;
/*
* 两数组尾合并，放置于第一个数组的末尾,从大到小合并
* */
public class Question88 {
    public static void main(String[] args) {
        //nums1的长度为m+n,nums初始时前m个数据有意义,因此合并时可以将元素放置于nums1的末尾而不必考虑元素被覆盖的问题
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, nums2.length);
        for (int i : nums1) {
            System.out.print(i);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1;
        int l = m + n - 1;
        if (n == 0)
            return;
        while (j >= 0){
            if (i >= 0 && nums1[i] >= nums2[j]){
                nums1[l--] = nums1[i--];
            } else {
                nums1[l--] = nums2[j--];
            }
        }
    }
}
