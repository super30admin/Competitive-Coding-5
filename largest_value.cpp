// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
public:
    vector<int> largestValues(TreeNode* root) 
    {
        vector<int> result;
        if(root == NULL)
            return result;
        queue<TreeNode* > q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            int max1 = INT_MIN;
            while(size-- > 0){
                TreeNode* curr = q.front();
                q.pop();
                max1 = max(max1,curr->val);
                if(curr->left!=NULL){
                    q.push(curr->left);
                }
                if(curr->right!=NULL){
                    q.push(curr->right);
                }
                
            }
            result.push_back(max1);
        }
        return result;
    }
};