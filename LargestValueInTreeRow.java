// Time Complexity : O(n), where n is number of nodes, since we need to visit each node
// Space Complexity : O(log n) + O(log n), stack space from dfs, space to store level max in hashmap 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// I guess the simpler approach is to do a level order traversal and keep track of the max element, bfs 
// The interviewer had asked to think of a dfs solution,
// dfs solution, since we traverse depth wise here, initial idea was to traverse all once to find the max depth
// then intialize an int[max_depth] to store max values at each level  
// then do a dfs, maintain a depth variable, set and update max value at each level
// but then rather than 2 pass, a one pass solution is to use a datastructure which allows dynamic addition of elements, used a HashMap

class Solution {
    private void dfs(TreeNode node, int depth, HashMap<Integer, Integer> map){
        if(node==null) return;
        
        if(!map.containsKey(depth)){
            map.put(depth, node.val);
        }
        else{
            map.put(depth, Math.max(node.val, map.get(depth))); 
        }
        
        dfs(node.left, depth+1, map);
        dfs(node.right, depth+1, map);
    }
    
    public List<Integer> largestValues(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int depth = 0;
        dfs(root, depth, map);
        
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i=0; i<map.size(); i++){
            result.add(map.get(i));
        }
        
        return result;
    }
}