// Time Complexity : O(N) where N represents the no.of nodes in the tree
// Space Complexity : O(H) where H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
// Submission Link: https://leetcode.com/submissions/detail/543018254/

class Solution {
    vector<int> result;
    int maxDepth;
public:
    vector<int> largestValues(TreeNode* root) {
        maxDepth = -1;
        helper(root, 0);
        
        return result;
    }
    
    void helper(TreeNode* root, int depth){
        if(root == NULL)
            return;
        
        if(depth > maxDepth){
            maxDepth = depth;
            result.push_back(root -> val);
        }
        else{
            result[depth] = max(root -> val, result[depth]);
        }
        
        helper(root -> left, depth + 1);
        helper(root -> right, depth + 1);
    }
};