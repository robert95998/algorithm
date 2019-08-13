package base;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int x, int left, int right) {
        this.val = x;
        this.left = new TreeNode(left);
        this.right = new TreeNode(right);
    }

    public TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    /**
     *       3
     *   /       \
     *   5        1
     * /  \      /  \
     * 6   2    0    8
     *    / \
     *   7   4
     */
    public static TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5, new TreeNode(6), new TreeNode(2, 7, 4));
        root.right = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        return root;
    }
}
