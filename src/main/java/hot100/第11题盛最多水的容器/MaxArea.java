package hot100.第11题盛最多水的容器;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int result = getResultBy2ZhiZhen(arr);
        System.out.println(result);
    }

    private static int getResultBy2ZhiZhen(int[] arr) {
        // 头指针
        int head = 0;
        // 尾指针
        int tail = arr.length - 1;
        // 最大容量
        int maxSize = 0;
        while (head != tail) {
            int height = arr[head] > arr[tail] ? arr[tail] : arr[head];
            maxSize = maxSize > height * (tail - head) ? maxSize : height * (tail - head);
            if (arr[head] > arr[tail]) {
                tail --;
            } else {
                head ++;
            }
        }
        return maxSize;
    }
}
