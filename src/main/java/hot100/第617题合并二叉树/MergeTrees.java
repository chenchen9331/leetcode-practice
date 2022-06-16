package hot100.第617题合并二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你两棵二叉树： root1 和 root2 。
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * 示例 2：
 *
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTrees {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode treeNode2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(4)));
        // 迭代
        TreeNode treeNode = getByDieDai(treeNode1, treeNode2);
        System.out.println(treeNode);

        // 递归
        TreeNode treeNode3 = getByDiGui(treeNode1, treeNode2);
        System.out.println(treeNode3);
    }

    private static TreeNode getByDiGui(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null) {
            return treeNode2;
        }
        if (treeNode2 == null) {
            return treeNode1;
        }
        TreeNode merage = new TreeNode(treeNode1.val + treeNode2.val);
        merage.left = getByDiGui(treeNode1.left, treeNode2.left);
        merage.right = getByDiGui(treeNode1.right, treeNode2.right);
        return merage;
    }

    private static TreeNode getByDieDai(TreeNode treeNode1, TreeNode treeNode2) {
        Queue<TreeNode> merageQ = new LinkedList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        if (treeNode1 == null) {
            return treeNode2;
        }
        if (treeNode2 == null) {
            return treeNode1;
        }
        q1.offer(treeNode1);
        q2.offer(treeNode2);
        TreeNode merage = new TreeNode(treeNode1.val + treeNode2.val);
        merageQ.offer(merage);
        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode mp = merageQ.poll();
            TreeNode p1 = q1.poll();
            TreeNode p2 = q2.poll();
            TreeNode l1 = p1.left;
            TreeNode l2 = p2.left;
            TreeNode r1 = p1.right;
            TreeNode r2 = p2.right;
            if (l1 != null || l2 != null) {
                // 有一个为空
                if (l1 != null && l2 != null) {
                    // 都不为空
                    TreeNode treeNode = new TreeNode(l1.val + l2.val);
                    mp.left = treeNode;
                    merageQ.offer(treeNode);
                    q1.offer(l1);
                    q2.offer(l2);
                } else if (l1 != null) {
                    mp.left = l1;
                } else if (l2 != null) {
                    mp.left = l2;
                }
            }
            if (r1 != null || r2 != null) {
                if (r1 != null && r2 != null) {
                    // 都不为空
                    TreeNode treeNode = new TreeNode(r1.val + r2.val);
                    mp.right = treeNode;
                    merageQ.offer(treeNode);
                    q1.offer(r1);
                    q2.offer(r2);
                } else if (r1 != null) {
                    mp.right = r1;
                } else {
                    mp.right = r2;
                }
            }
        }
        return merage;
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
