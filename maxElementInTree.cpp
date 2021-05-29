// Time Complexity :O(n) where n in the number of nodes 
// Space Complexity : O(h) where h is height of the tree  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    vector<int> res;
public:
    vector<int> largestValues(TreeNode* root) {
        if(!root) return res;
        dfs(root,0);
        return res;
    }
    void dfs(TreeNode* root, int level){
        //base
        if(!root) return;
        //logic
        //check with curr max and update
        if(res.size() == level)
            res.push_back(root->val);
        //
        if(root->val > res[level])
            res[level] = root->val;
        dfs(root->left,level+1);
        dfs(root->right,level+1);
    }
};