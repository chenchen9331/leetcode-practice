package hot100.第53题最大子数组的和;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        // 贪心算法
        int maxSubArray = getMaxSubArray(arr);
        System.out.println(maxSubArray);

        // 动态规划
        int asInt = getMaxSubArray2(arr);
        System.out.println(asInt);
    }

    private static int getMaxSubArray2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < 0) {
                continue;
            } else {
                arr[i] = arr[i] + arr[i - 1];
            }

        }
        int asInt = Arrays.stream(arr).max().getAsInt();
        return asInt;
    }

    private static int getMaxSubArray(int[] arr) {
        int result = 0;
        int maxAnts = arr[0];
        for (int x : arr) {
            // 若之前的和还不如当前元素自己本身大则抛弃之前的结果
            result = Math.max(result + x, x);
            maxAnts = Math.max(maxAnts, result);
        }
        return maxAnts;
    }
}
