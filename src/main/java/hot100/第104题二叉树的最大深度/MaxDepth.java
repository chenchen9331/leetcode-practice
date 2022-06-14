package hot100.第104题二叉树的最大深度;

import hot100.第101题对称二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20,new TreeNode(15), new TreeNode(7)));
        // 递归
        int n = diGui(treeNode);
        System.out.println(n);

        // 迭代
        int j = dieDai(treeNode);
        System.out.println(j);
    }

    private static int dieDai(TreeNode treeNode) {
        Queue<TreeNode> q = new LinkedList<>();
        if (treeNode == null) {
            return 0;
        }
        q.offer(treeNode);
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode p = q.poll();
                if (p.left != null) {
                    q.offer(p.left);
                }
                if (p.right != null) {
                    q.offer(p.right);
                }
                size --;
            }
            ans ++;
        }
        return ans;
    }

    private static int diGui(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diGui(root.left);
        int right = diGui(root.right);

        return Math.max(left, right) + 1;
    }
}
