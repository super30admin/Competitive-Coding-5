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
 Time Complexity = O(N)
 Space Complexity = O(h)
 Where N is the number of nodes and h is the hieght of the tree.
 */
class Solution {
public:
    vector<int> result;
    void dfs(TreeNode* root, int lvl)
    {
        //base
        if(root==NULL)
            return;
        if(lvl==result.size())
            result.push_back(root->val);
        else
        {
            result[lvl] = max(root->val, result[lvl]);
        }
        
        //logic
        dfs(root->left, lvl+1);
        dfs(root->right, lvl+1);
    }
    vector<int> largestValues(TreeNode* root) {
        if(root==NULL)
            return result;
        dfs(root, 0);
        return result;
    }
};
