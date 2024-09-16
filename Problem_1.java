// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
    private HashMap<Integer,List<Integer>> hash;
    public List<Integer> largestValues(TreeNode root) {
        hash=new HashMap<Integer,List<Integer>>();
        List<Integer> result=new ArrayList<>();
        helper(root,0);
        int max=Integer.MIN_VALUE;
        //System.out.println(hash);
        for(int i:hash.keySet()){
            for(int j:hash.get(i)){
                if(j>max){
                    max=j;
                }
            }
            result.add(max);
            max=Integer.MIN_VALUE;
        }
        return result;
    }
    public void helper(TreeNode node,int level){
        if(node==null){
            return;
        }
        if(!hash.containsKey(level)){
            hash.put(level,new ArrayList<Integer>());
            hash.get(level).add(node.val);
        }else{
            hash.get(level).add(node.val);
        }
        helper(node.left,level+1);
        helper(node.right,level+1);
        
    }
}

///////
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
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result=new ArrayList<>();
        helper(root,0);
       // System.out.println
        return result;
    }
    public void helper(TreeNode node,int level){
        if(node==null){
            return;
        }
        if(level==result.size()){
            result.add(node.val);
        }else{
            int max=Math.max(node.val,result.get(level));
            result.set(level,max);
        }
        helper(node.left,level+1);
        helper(node.right,level+1);
        
    }
}
////

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
        if(root==null) return result;
        Queue<TreeNode> qu=new LinkedList<TreeNode>();
        qu.add(root);
        result.add(root.val);
        int max=Integer.MIN_VALUE;
        while(!qu.isEmpty()){
            int size=qu.size();
             max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode temp=qu.remove();
                if(temp.left!=null){
                    qu.add(temp.left);
                    max=Math.max(max,temp.left.val);
                }
                if(temp.right!=null){
                    qu.add(temp.right);
                    max=Math.max(max,temp.right.val);
                }
            }
            System.out.println(max);
            result.add(max);
           
        }
        result.remove(result.size()-1);
        return result;
    }
}