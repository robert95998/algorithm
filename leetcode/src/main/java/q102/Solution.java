/*
* 四川生学教育科技有限公司
* Copyright (c) 2015-2025 Founder Ltd. All Rights Reserved.
*
* This software is the confidential and proprietary information of
* Founder. You shall not disclose such Confidential Information
* and shall use it only in accordance with the terms of the agreements
* you entered into with Founder.
*
*/
package q102;

import base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * BFS的做法
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        //比ArrayDeque好一点(arrayDeque pop之后并没有移除节点，只是移动了头指针，浪费内存；等于申请了n长度的数组，但用了头指针后的空间)
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> cur_level = new ArrayList<>(size);
            //循环此层的节点
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                cur_level.add(pop.val);

                //添加下一层节点（注意左右顺序）
                if (pop.left != null) deque.offer(pop.left);
                if (pop.right != null) deque.offer(pop.right);
            }
            res.add(cur_level);
        }
        return res;
    }

    /**
     * DFS实现
     * 递归
     *
     * @param root
     * @return
     */
    /*public List<List<Integer>> levelOrder2(TreeNode root) {

    }

    public void dfs(TreeNode root){
        if (root == null) return
    }*/

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        System.out.println(new Solution().levelOrder(buildTree()));
        CompletableFuture<Boolean> f = CompletableFuture.completedFuture(true);
        System.out.println(f.get());
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5, new TreeNode(6), new TreeNode(2, 7, 4));
        root.right = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        return root;
    }
}