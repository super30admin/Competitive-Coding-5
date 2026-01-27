//way1
//BFS
//List - ans
//travel level by level - help of queue
//Get max value at every level - queue help
//Store that max value in list - once level traversal is completed
//TC : O(n)
//SC: constant
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!(queue.isEmpty())){
            int size=queue.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                max=Math.max(max,curr.val);

                if(curr.left!=null){
                    queue.add(curr.left);
                }

                if(curr.right!=null){
                    queue.add(curr.right);
                }

            }

            ans.add(max);
        }
        return ans;
        
    }
}

//way2
//DFS
//Use a result as list- passed as reference
//Travel through tree
//check level
//If that level element is not present in list - add it to list
//Else compare that level element from list with current element
//If greater - update it in list at it's respective level
//TC:O(n)
//SC:O(h)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        helper(root,0,result);
        return result;
        
    }

    private void helper(TreeNode root,int level,List<Integer> result){
        //base case
        if(root==null){
            return;
        }


        //actual case
        if(result.size()==level){
            result.add(root.val);
        }
        int max=result.get(level);
        result.set(level,Math.max(max,root.val));

        helper(root.left,level+1,result);
        helper(root.right,level+1,result);
    }
}
