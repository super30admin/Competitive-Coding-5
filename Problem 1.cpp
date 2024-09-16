//Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
public:
    //DFS solution
    void helper(TreeNode* root, int level, vector<int> &res  ){
        if(root==NULL) return;
        
        if(res.size()==level){
            res.push_back(root->val);
        }
        
        else{
            if(root->val>res[level])
                res[level] = root->val;
            
        }

        helper(root->left, level+1, res);
        
        helper(root->right, level+1, res);

        
    }
    
    vector<int> largestValues(TreeNode* root) {
        vector<int> res;
        if(root==NULL) return res;
        helper(root, 0,res);
        
        
        return res;
        
    }
};