/*
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        
        result = []
        q = collections.deque()
        q.append(root)
        
        while len(q) > 0:
            max_value = float('-inf')
            size = len(q)
            
            for i in range(size):
                node = q.popleft()
                if node.val > max_value:
                    max_value = node.val
                    
                if node.left is not None:
                    q.append(node.left)
                if node.right is not None:
                    q.append(node.right)
            result.append(max_value)
        return result
*/

// Time Complexity : O(n) where n is no of nodes in tree
// Space Complexity : O(n/2) as worst case would be when all the children of last level are there in queue 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I maintained a queue and went through each level to see what is max element
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = q.size();
            
            for (int i=0; i<size; i++){
                TreeNode node = q.poll();
                if (node.val > max)
                    max = node.val;
                
                if (node.left != null)
                    q.add(node.left);
                
                if (node.right != null)
                    q.add(node.right);
            }
            result.add(max);
        }
        return result;
    }
}