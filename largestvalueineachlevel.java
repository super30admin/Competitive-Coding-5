
//time complexity: O(n)
//space complexity: O(n)

//we will use depth first search and compare the values to find the maximum at each level
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();        
        if(root == null) return result;
         
        dfs(root, 0, result);        
        return result;
    }
     
    public void dfs(TreeNode node, int level, List<Integer> result){
         
        if(node == null) return;
         
        if(result.size() == level){
            result.add(node.val);
        }else {            
            if(result.get(level) < node.val){
                result.set(level, node.val);
            }
        }
         
        dfs(node.left, level+1, result);
        dfs(node.right, level+1, result);        
    }
    }