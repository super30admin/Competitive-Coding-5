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
        
        vector<int> result;
        if(root == NULL)  return result;
        //BFS 
        
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty()) {
            
            int size = q.size();
            
            int maxValue = INT_MIN;
            //every level loop as size of queue.
            while(size != 0){
                TreeNode* topElement = q.front();
                maxValue = max(topElement->val,maxValue);
                q.pop();
                if (topElement != NULL && topElement->left != NULL) {
                   q.push(topElement->left);  
                }
                
                if(topElement != NULL && topElement->right != NULL) {
                   q.push(topElement->right);  
                }
                
                size--;
            }
            result.push_back(maxValue);
        }
        
        return result;
        
    }
};