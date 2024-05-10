//Time O(n)
//Space O(n)
//Leetcode: yes
//Issue seen: none
class Solution {
public:
   vector<int> ans;
   void dfs(TreeNode* node, int level){
    if(!node) return ;
    if(level == ans.size()){
        ans.push_back(node->val);
    } else {
        ans[level] = max(ans[level], node->val);
    }
    if(node->left){
      dfs(node->left, level+1);
    }
    if(node->right){
      dfs(node->right, level+1);
    }

   }
   vector<int> largestValues(TreeNode* root) {
        if(!root) return ans;
        dfs(root, 0);
        return ans;
    }
    /*
    vector<int> largestValues(TreeNode* root) {
        queue<TreeNode* > q;
        vector<int> ans;
        if(!root) return ans;

        q.push(root);
        while(!q.empty()){
            int n = q.size();
            int maxVal = INT_MIN;
            for(int i=0; i<n; i++){
              TreeNode* node = q.front();
              q.pop();
              maxVal = max(maxVal, node->val);

              if(node->left) {
                q.push(node->left);
            
              }
              if(node->right){
                q.push(node->right);
              }

            }
            ans.push_back(maxVal);
            
        }
        return ans;
        
    }*/
};
