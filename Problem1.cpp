// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 
#include<vector>
#include<iostream>
#include<queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 };

//BFS

class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        
        if(root == NULL)
            return {};
        
        vector<int> result;
        queue<TreeNode*> q1;
        TreeNode *curr = NULL;
        
        q1.push(root);
        
        while(!q1.empty()){
            int size = q1.size();
            int max = INT_MIN;
            while(size > 0){
                curr = q1.front();
                q1.pop();
                if(curr->val > max)
                    max = curr->val;
                
                if(curr->left != NULL)
                    q1.push(curr->left);
                
                if(curr->right != NULL)
                    q1.push(curr->right);
                
                --size;
            }
            
            result.push_back(max);
        }
        
        return result;
    }
};

// DFS
class Solution {
    
    vector<int> result;
    public:
    vector<int> largestValues(TreeNode* root) {
    
       if(root == NULL)
           return {};

        dfs(root, 0);
        return result;
    }
    
    void dfs(TreeNode *root, int level){
        
        if(root == NULL)
            return;
        
        if(level == result.size())
            result.push_back(root->val);
        else
            if(result[level] < root->val)
                result[level] = root->val;
        
        dfs(root->left, level + 1);
        dfs(root->right, level + 1);
    }
};