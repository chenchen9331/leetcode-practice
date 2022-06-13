package hot100.第94题二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        // 递归调用法
        getByDiGui(treeNode);
    }

    private static void getByDiGui(TreeNode treeNode) {
        List<Integer> res = new ArrayList<>();
        diGui(treeNode, res);
        res.stream().forEach(integer -> System.out.println(integer));
    }

    private static void diGui(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }
        diGui(treeNode.left, res);
        res.add(treeNode.val);
        diGui(treeNode.right, res);
    }
}
