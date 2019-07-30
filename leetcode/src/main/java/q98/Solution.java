package q98;


import base.TreeNode;
import org.jetbrains.annotations.NotNull;

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
     * 二叉搜索树（压扁排成一条直线）一定是单调递增的，即不存在重复元素并且是递增的；
     *
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

    /**
     *
     * 对于每个节点的逻辑：左子树通过检查 && 当前节点大于前继节点 && 右子树通过检查
     * <ul>
     *     <li>“当前节点大于前继节点”这个逻辑其实就是核心逻辑：前继节点肯定位于当前节点的左侧，
     *     因为“helper(r.left)会把（前继节点的）左子树全部检查完”才有可能赋值前继节点</li>
     *     <li>忠告：对于递归，你始终只站在当前节点的立场，不然你试图复现它的执行过程那是相当费脑的；当然作为程序员，你是应该时不时要在大脑中练习一下计算机的计算过程</li>
     * </ul>
     *
     * @param r
     * @return
     */
    public boolean helper(TreeNode r) {
        if (r == null) return true;

        System.out.println("r: " + r);
        if (prev != null) System.out.println("prev: " + prev);
        if (!helper(r.left)) return false;
        if (prev != null && prev.val >= r.val) return false;
        prev = r;

        System.out.println("right check start for [" + r.val + "]");
        boolean helper = helper(r.right);
        System.out.println("check over for [" + r.val + "]" + " result: " + helper);
        return helper;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree1();
        System.out.println(new Solution().isValidBST2(root));

        System.out.println(inorder(root));

    }

    @NotNull
    private static TreeNode buildTree1() {
        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(1);
        root.left = left;

        TreeNode right = new TreeNode(4);
        right.left = new TreeNode(3);
        right.right = new TreeNode(6);

        root.right = right;
        return root;
    }

    @NotNull
    private static TreeNode buildTree2() {
        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        root.left = left;

        TreeNode right = new TreeNode(6);
        root.right = right;
        return root;
    }

    @NotNull
    private static TreeNode buildTree3() {
        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(1);
        root.left = left;

        TreeNode right = new TreeNode(7);
        right.left = new TreeNode(6);
        right.right = new TreeNode(8);

        root.right = right;
        return root;
    }
}