package q98;


import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 二叉搜索树（压扁排成一条直线）一定是单调递增的，即不存在重复元素；
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        List<Integer> inorder = inorder(root);
        List<Integer> sorted = inorder.stream().distinct().sorted().collect(Collectors.toList());
        return inorder.equals(sorted);
    }

    /**
     * 中序遍历
     *
     * @param r
     * @return
     */
    public static List<Integer> inorder(TreeNode r) {
        List<Integer> result = new ArrayList<>();
        if (r == null) return result;

        result.addAll(inorder(r.left));
        result.add(r.val);
        result.addAll(inorder(r.right));
        return result;
    }

    // ==========================

    public boolean isValidBST2(TreeNode root) {
        return helper(root);
    }

    TreeNode prev = null;

    public boolean helper(TreeNode r) {
        if (r == null) return true;

        if (!helper(r.left)) return false;
        if (prev != null && r.val >= prev.val) return false;
        prev = r;

        return helper(r.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(1);
        root.left = left;

        TreeNode right = new TreeNode(4);
        right.left = new TreeNode(3);
        right.right = new TreeNode(6);
        root.right = right;

        System.out.println(inorder(root));

        System.out.println(new Solution().isValidBST2(root));
    }
}