package lby.com.offer;
/*
* 剑指 Offer 53 - I. 在排序数组中查找数字 I
*   统计一个数字在排序数组中出现的次数。
*   0 <= nums.length <= 105
*   -109 <= nums[i] <= 109
*   nums 是一个非递减数组
*   -109 <= target <= 109
*
* 解:
*   思路1:由于nums是非递减数组, 因此可以用二分查找, 获取某个target的索引, 然后在这个索引左右寻找
*   思路2:用二分查找的变形, 确定target再nums的左右边界, 然后边界相减即可
* */
public class Offer53 {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index == -1)
            return 0;
        int count = 1;
        int offset = 1;
        while (true){
            if (index+offset < nums.length){
                if (nums[index+offset] == target){
                    count++;
                    offset++;
                } else break;
            } else break;
        }
        offset = 1;
        while (true){
            if (index-offset >= 0){
                if (nums[index-offset] == target){
                    count++;
                    offset++;
                } else break;
            } else break;
        }
        return count;
    }

    public int binarySearch(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public int search2(int[] nums, int t) {
        int n = nums.length;
        if (n == 0) return 0;
        int a = -1, b = -1;
        /*
        * 下面两个while是二分查找的边界变形! 巧妙在于mid设置以及r和l的更新方式!
        * */
        // 二分出左边界
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= t) r = mid;
            else l = mid + 1;
        }
        if (nums[r] != t) return 0;
        a = r;

        // 二分出右边界
        l = 0; r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= t) l = mid;
            else r = mid - 1;
        }
        if (nums[r] != t) return 0;
        b = r;

        return b - a + 1;
    }
}
