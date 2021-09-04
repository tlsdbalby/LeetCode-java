package lby.com.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
* 15. 三数之和
*   给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
*   请你找出所有和为 0 且不重复的三元组。
*   注意：答案中不可以包含重复的三元组。
* 解:
*   思路1: 暴力+剪枝 遍历数组找三个元素和为0
*           剪枝1: 数组排序
*           剪枝2: 第一个元素必须小于0
*           剪枝3: i j(i+1) k(最大元素) 位置元素加起来若是 > 0, 则 下标向小的方向移动(k--), 若 < 0 则j++
* */
public class Question15 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        if (n >= 3){
            Arrays.sort(nums);
            for (int first = 0; first < n; first++){
                if (nums[first] > 0)
                    break;
                if (first > 0 && nums[first] == nums[first - 1])
                    continue;
                int third = n - 1;
                for (int second = first + 1; second < n; second++){
                    if (second > first + 1 && nums[second] == nums[second-1]){
                        continue;
                    }
                    while (third > second && nums[first] + nums[second] +nums[third] > 0)
                        third--;
                    if (third == second)
                        break;
                    if (nums[first] + nums[second] + nums[third] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        lists.add(list);
                    }

                }
            }
        }
        return lists;
    }

    public void addList(List<List<Integer>> lists, int a, int b, int c){
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        lists.add(list);
    }
}
