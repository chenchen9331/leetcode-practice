package hot100.第226题反转二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 示例 2：
 *
 *
 *
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *
 */
public class InvertTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
//        TreeNode result = getResultByDiGui(treeNode);
//        System.out.println(result);

        TreeNode result2 = getResultByDieDai(treeNode);
        System.out.println(result2);
    }

    private static TreeNode getResultByDieDai(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (treeNode != null) {
            queue.offer(treeNode);
        }
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            TreeNode temp = t.left;
            t.left = t.right;
            t.right = temp;
            if (t.left != null) {
                queue.offer(t.left);
            }
            if (t.right != null) {
                queue.offer(t.right);
            }
        }
        return treeNode;
    }

    private static TreeNode getResultByDiGui(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        TreeNode left = getResultByDiGui(treeNode.left);
        TreeNode right = getResultByDiGui(treeNode.right);
        treeNode.left = right;
        treeNode.right = left;
        return treeNode;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}