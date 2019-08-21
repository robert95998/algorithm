package q104;

import base.TreeNode;

import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxDepth2(TreeNode.buildTree()));
    }

    /**
     * BFS实现
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int depth = 0;

        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            depth++;

            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) deque.add(poll.left);
                if (poll.right != null) deque.add(poll.right);
            }
        }
        return depth;
    }

    /**
     * 分治递归
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));
    }
}
