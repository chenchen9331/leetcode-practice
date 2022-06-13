package hot100.第101题对称二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 */
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2,new TreeNode(4), new TreeNode(3)));
        // 递归方法
        boolean flag = diGui(treeNode, treeNode);
        System.out.println(flag);

        // 迭代方法
        boolean flag2 = diDai(treeNode, treeNode);
        System.out.println(flag2);
    }

    private static boolean diDai(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (p != null && q != null) {
            queue.offer(q);
            queue.offer(p);
        }
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if ((p == null || q == null) || (p.val != q.val)) {
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }

    private static boolean diGui(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && diGui(p.left, q.right) && diGui(p.right, q.left);

    }
}
