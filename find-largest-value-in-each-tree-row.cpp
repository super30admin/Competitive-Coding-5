//Time - O(n) n-nodes in tree
//Space - O(n)
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
       if(root == NULL) return vector<int>(); 
        
        queue<TreeNode*> q;
        vector<int> ret;
        q.push(root);
        TreeNode* node;
        int size = 0,Max = INT_MIN;
        
        while(!q.empty()){
            size = q.size(); 
            Max = INT_MIN;
            for(int i = 0;i<size;i++){
                node = q.front();
                q.pop();
                if(Max<node->val) Max = node->val;
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
           ret.push_back(Max);
        }
        
        return ret;
        
    }
};