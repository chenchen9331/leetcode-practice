package hot100.第19题删除链表的倒数第N个节点;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2));
        int n = 2;
        ListNode result = getResultByStack(listNode, n);
        ListNode result2 = getResultBy2ZhiZhen(listNode, n);
    }

    private static ListNode getResultBy2ZhiZhen(ListNode listNode, int n) {
        ListNode dummy = new ListNode(0, listNode);
        ListNode first = listNode;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    private static ListNode getResultByStack(ListNode listNode, int n) {
        ListNode dummy = new ListNode(0, listNode);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
