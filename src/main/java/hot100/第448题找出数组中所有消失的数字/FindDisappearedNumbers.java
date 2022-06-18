package hot100.第448题找出数组中所有消失的数字;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[2]
 *
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = getResult(nums);
    }

    private static List<Integer> getResult(int[] nums) {
        for (int num : nums) {
            int x = (num - 1) % nums.length;
            nums[x] = nums[x] + nums.length;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] <= nums.length) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
