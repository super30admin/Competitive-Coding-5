// TC: O(N) where N is the number of nodes in the tree;
// SC: O(depth of the tree)

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
public:
    vector<int> largestValues(TreeNode* root) {
        queue<TreeNode*>q;
        vector<int>result;
        
        if(root == NULL)return result;
        q.push(root);
        while(!q.empty()){
            int lvl_size = q.size();
            int lvl_max = INT_MIN;
            for(int i = 0; i < lvl_size;i++){
                root = q.front();q.pop();
                lvl_max = max(lvl_max,root->val);
                if(root->left)q.push(root->left);
                if(root->right)q.push(root->right);
            }
            result.push_back(lvl_max);
        }
        return result;
        
    }
};