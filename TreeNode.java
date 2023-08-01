public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
       this.val = x;
    }

    TreeNode() {}
    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}
