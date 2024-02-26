// https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

// Time: BFS - O(N) , N is number of nodes
// Space: BFS - O(N), N is the number of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    //DFS
    // Time - O(N), N is number of nodes
    // Space - O(H), where H is height of the tree O(N) in worst case
    public List<Integer> largestValuesDFS(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }

        Stack<TreeNode> parent=new Stack<>();
        Stack<Integer> level=new Stack<>();
        parent.add(root);
        level.add(0);

        List<Integer> result=new ArrayList<>();

        while(!parent.isEmpty()){
            // Process the tos
            TreeNode curr=parent.pop();
            int currLevel=level.pop();

            // Check if the level has been seen, if not add a new entry in result
            if(result.size()<=currLevel){
                result.add(curr.val);
            }

            // Update max for current level
            result.set( currLevel, Math.max(curr.val, result.get(currLevel)));

            // Process left and right children
            if(curr.left!=null){
                parent.add(curr.left);
                level.add(currLevel+1);
            }
            if(curr.right!=null){
                parent.add(curr.right);
                level.add(currLevel+1);
            }
            
        }

        return result;
    }

    // BFS
    // Time: O(N) , N is number of nodes
    // Space: O(N), N is the number of nodes
    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        List<Integer> result=new ArrayList<>();

        while(!q.isEmpty()){
            int size_n=q.size();

            int max=Integer.MIN_VALUE;
            // Process the level
            for(int i=0;i<size_n;i++){
                TreeNode front=q.poll();

                // Update max for level
                max=Math.max(max, front.val);

                // Process the children
                if(front.left!=null){
                    q.add(front.left);
                }
                if(front.right!=null){
                    q.add(front.right);
                }
            }

            result.add(max);
        }

        return result;
    }
}