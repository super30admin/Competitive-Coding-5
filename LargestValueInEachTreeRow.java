// Time Compexity = O(n)
// Space Complexity = O(n)


// BFS - traverse through all nodes level by level and find the maximum
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List <Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size(); //2
            int max = -2147483648;

            for(int i = 0; i< size; i++){

                TreeNode curr = q.poll(); //2

                if(curr.val > max){ 
                    max = curr.val; 
                }

                if(curr.left != null)
                    q.add(curr.left); 
                if(curr.right != null)
                    q.add(curr.right); 

            }

            result.add(max);
        }
        return result;
    }
}