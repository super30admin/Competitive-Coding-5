// Time Complexity : O(n)
// Space Complexity : O(maximum diameter of tree) for the stack we created to store them
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


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
        if(root == NULL) return result;
        queue<TreeNode* > myqueue ;
        
        myqueue.push(root);
        
        while(!myqueue.empty()){
            
            int size = myqueue.size();
            int temp = INT_MIN;
          
            
            for(int i = 0; i <size; i++){
                  
            TreeNode* curr = myqueue.front();
            myqueue.pop();
            if(curr->val > temp){
                temp = curr->val;
            }
                
            if(curr->left!= NULL){
                myqueue.push(curr->left);
            }
                
            if(curr->right!= NULL){
                myqueue.push(curr->right);
            }
                
                
            }
            result.push_back(temp);
            
        }
        
        return result;
    }
};