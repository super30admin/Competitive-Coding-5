//The approach here is to use level order traversal using BFS to traverse through each level and finding the maximum value at each level and adding it to the result list
//Time Complexity: O(n), where n is the number of nodes in the tree
//Space Complexity: O(n)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int size = 0;
        if(root == null){
            return result;
        }
        q.add(root);
        while(!q.isEmpty()){
            size = q.size();
            int max  = Integer.MIN_VALUE;
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                max = Math.max(curr.val, max);
                if(curr.left!= null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            result.add(max);
        }
        return result;        
    }
}