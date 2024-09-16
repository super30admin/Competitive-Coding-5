// Time Complexity : O(N)
// Space Complexity : O(2^l) where l is level
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Needed hints

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
        vector<int> res;
        if(root==NULL){
            return {};
        }
        queue<TreeNode*> q;
        int maxi;
        int _size = 0;
        q.push(root);
        while(q.size()!=0){
            maxi = INT_MIN;
            _size = q.size();
            for(int i=0;i<_size;i++){
                TreeNode *temp = q.front();
                q.pop();
                if(temp->val>=maxi){
                    maxi = temp->val;
                }
                if(temp->left!=NULL){
                    q.push(temp->left);
                }
                if(temp->right!=NULL){
                    q.push(temp->right);
                }
            }
            res.push_back(maxi);
        }
        return res;
    }
};
