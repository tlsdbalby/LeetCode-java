package lby.com.question;
/*
* 75. 颜色分类
*   给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
*   此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
* 解：
*   思路1: 双指针,一个指针遍历,一个指针换值,
*   从头开始遍历数组,若是遇到1, 则找之后第一个0,找到则换位+遍历指针移动;
*   遇到2则从尾找1或0,找到1则换位但遍历指针不移动,找到0则换位+遍历指针移动.
* */
public class Question75 {
    public static void main(String[] args) {

    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n > 1) {
            int e = n - 1;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 1) {
                    for (int k = i + 1; k < e+1; k++) {
                        if (nums[k] == 0) {
                            nums[i] = 0;
                            nums[k] = 1;
                            break;
                        }
                    }
                } else if (nums[i] == 2) {
                    for (int l = e; l > i; l--) {
                        if (nums[l] == 0) {
                            nums[i] = 0;
                            nums[l] = 2;
                            e = l;
                            break;
                        } else if (nums[l] == 1){
                            nums[i] = 1;
                            nums[l] = 2;
                            e = l;
                            i--;
                            break;
                        }
                    }
                }
            }
        }
    }
}
