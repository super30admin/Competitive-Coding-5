//TC: O(n) where n is the number of nodes
//SC: O(n) since at most, at any level, there could be n/2 elements in the queue

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
        
        vector<int> ans;
        queue<TreeNode*> q;
        q.push(root);
        if(root==NULL)
            return ans; 
        
        while(!q.empty()){
            int qsize = q.size();            
            int maxval = INT_MIN;
            
            for(int i=0; i<qsize; i++){
                TreeNode *curr = q.front();
                q.pop();
                if(curr->left!=NULL)
                    q.push(curr->left);
                if(curr->right!=NULL)
                    q.push(curr->right);
                if(curr->val > maxval)
                    maxval = curr->val;
            }
            ans.push_back(maxval);
            
        }
                
        return ans;
        
    }
};