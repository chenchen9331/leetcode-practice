package hot100.第3题无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "bbbbbbbbbbbbbb";
        int lengthOfLongestSubstring = getLengthOfLongestSubstring(s);
        System.out.println(lengthOfLongestSubstring);
    }

    private static int getLengthOfLongestSubstring(String s) {
        // 检查是否出现重复字符集合
        Set<Character> hashset = new HashSet<>();
        int size = s.length();
        // 右指针
        int ret = -1;
        // 不重复字符串最大长度
        int ant = 0;

        for (int i = 0; i < size; i ++) {
            // 左指针向右移动，删除set中对应元素
            if (i != 0) {
                hashset.remove(s.charAt(i - 1));
            }
            // 右指针向右移动判断是否出现重复字符
            while(ret + 1 < size && !hashset.contains(s.charAt(ret + 1))) {
                hashset.add(s.charAt(ret + 1));
                ret ++;
            }
            ant = Math.max(ant, ret - i + 1);
        }
        return ant;
    }
}
