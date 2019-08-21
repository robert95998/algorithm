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

    public static TreeNode buildTree1() {
        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(1);
        root.left = left;

        TreeNode right = new TreeNode(4);
        right.left = new TreeNode(3);
        right.right = new TreeNode(6);

        root.right = right;
        return root;
    }

    public static TreeNode buildTree2() {
        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        root.left = left;

        TreeNode right = new TreeNode(6);
        root.right = right;
        return root;
    }

    public static TreeNode buildTree3() {
        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(1);
        root.left = left;

        TreeNode right = new TreeNode(7);
        right.left = new TreeNode(6);
        right.right = new TreeNode(8);

        root.right = right;
        return root;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
