// Time Complexity : O(n)
// Space Complexity : O(l) ==> level 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach



import java.util.ArrayList;
import java.util.List;


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


public class maxAtLevel{

    public List<Integer> maxlevel(TreeNode root){
        
        List<Integer> result= new ArrayList<>() ;
        if(root==null)
            return result;

        // dfs
        dfs(root, result, 0);


        //bfs 

    /*    Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            int max=Integer.MIN_VALUE;

            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();


                //logic
                max=Math.max(max, temp.val);

                // navigate the tree
                if(temp.left!=null)
                    q.add(temp.left);

                if(temp.right!=null)
                    q.add(temp.right);
            }
            result.add(max);

        }
*/


        return result;
    }

    private void dfs(TreeNode node, List<Integer>result, int level ){
        //base case
        if(node==null)
            return;

        // logic

        if(level==result.size()){
            result.add(node.val);

        }else{
            result.set(level, Math.max(node.val, result.get(level)));
        }

        // recursion call
        dfs(node.left, result, level+1);
        dfs(node.right, result, level+1);

    }
}