//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        
        if(root==NULL)
            return {};
        
        vector<int> ans;
        int val=INT_MIN;
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty()){
            int size=q.size();
            val=INT_MIN;
            while(size--){
                TreeNode* temp=q.front();
                q.pop();
                if(val<temp->val){
                    val=temp->val;
                }
                if(temp->left){
                    q.push(temp->left);
                }
                if(temp->right){
                    q.push(temp->right);
                }
            }
            ans.push_back(val);
        }
          
        return ans;
    }
};