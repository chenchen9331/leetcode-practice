package hot100.第234题回文链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：false
 *  
 *
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1,new ListNode(2, new ListNode(1))));
        // 双指针
        boolean flag = getBy2ZhiZhen(listNode);
        System.out.println(flag);

        // 反转链表比较
        boolean flag2 = getByMethod2(listNode);
        System.out.println(flag2);
    }

    private static boolean getByMethod2(ListNode listNode) {
        ListNode copy = listNode;
        ListNode cur = null;
        ListNode pre = listNode;
        while (pre != null) {
            ListNode next = pre.next;
            pre.next = cur;
            cur = pre;
            pre = next;
        }

        while (copy != null) {
            if (copy.val != cur.val) {
                return false;
            }
            copy = copy.next;
            cur = cur.next;
        }
        return true;
    }

    private static boolean getBy2ZhiZhen(ListNode listNode) {
        List<Integer> arr = new ArrayList<>();
        ListNode currentNode = listNode;
        while (currentNode != null) {
            arr.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int first = 0;
        int last = arr.size() - 1;

        while (first != last) {
            if (arr.get(first) == arr.get(last)) {
                first ++;
                last --;
            } else {
                return false;
            }
        }
        return true;
    }
}
