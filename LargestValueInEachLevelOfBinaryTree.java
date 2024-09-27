// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInEachLevelOfBinaryTree {

    // Using BFS Time: O(n) Space: O(n)

    public List<Integer> largestValuesBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();

            int max = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++){
                TreeNode dummy = q.remove();
                if(dummy.val > max){
                    max = dummy.val;
                }

                if(dummy.left != null){q.add(dummy.left);}
                if(dummy.right != null){q.add(dummy.right);}
            }

            result.add(max);

        }
        return result;
    }

    // Using DFS Time: O(n) Space: O(1) (without stack)

    public List<Integer> largestValuesDFS(TreeNode root) {

        List<Integer> result  = new ArrayList<>();

        if(root == null){
            return result;
        }

        dfs(root, result, 0);

        return result;
    }

    private void dfs(TreeNode root, List<Integer> result, int level){

        if( root == null){
            return;
        }

        // if element is not present fr given level in the list
        if(result.size() == level){
            result.add(root.val);
        } else {
            int value = result.get(level);
            if(value < root.val){
                result.set(level, root.val);
            }
        }

        if(root.left != null){
            dfs(root.left, result, level+1);
        }


        if(root.right != null){
            dfs(root.right, result, level+1);
        }

    }
}
