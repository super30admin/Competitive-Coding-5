//I did dfs in interview
//bfs is wayy to easy for this one
//O(n) + O(n)
class Solution {
public:
    
    vector<int> ans;
    vector<int> largestValues(TreeNode* root) {
        
        int height =0;
        dfs(root,0);
        return ans;
    }
    void dfs(TreeNode* root, int height){
        //base case
        if(!root) return;
        if(ans.size()==height){
            ans.push_back(root->val);
        }
        else {
            ans[height] = max(ans[height],root->val);
            
            //ans[height]= root->val
        }
        dfs(root->left, height+1);
        dfs(root->right, height+1);   
    }
    
};
