import java.util.ArrayList;
import java.util.List;

/*
Time Complexity: O(N), here N is the number of nodes in the tree
Space Complexity: O(H), H is the height of the tree
Run on leetcode: Yes

Approach:
1. The problem is a variation of Level Order traversal, so for every level, I am taking maximum value for the level
2. And adding it to resultant array list recursively, I used DFS to solve this
 */
public class MaximumOfAllTheRowsOfTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private static List<Integer> largestVals;
    public static List<Integer> largestValues(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        largestVals = new ArrayList<>();

        levelOrderTraversal(root,0);
        return largestVals;
    }
    public static void levelOrderTraversal(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(largestVals.size() == level){
            largestVals.add(root.val);
        }else{
            largestVals.set(level,Math.max(root.val, largestVals.get(level)));
        }
        if(root.left!= null){
            levelOrderTraversal(root.left, level+1);
        }
        if(root.right!= null){
            levelOrderTraversal(root.right, level+1);
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);

        System.out.println("Largest Value in Each Tree Row: "+largestValues(root));

    }
}
