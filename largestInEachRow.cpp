//BFS
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Level order traversal using BFS
// 2. At each level, reset a max variable and update it with max at that level

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
        if(root == nullptr)
            return result;
        queue<TreeNode*> q; 
        int max=INT_MIN;
        int size=0;
        q.push(root);
        while(!q.empty()){
            size = q.size();
            max=INT_MIN;
            for(int i=0;i<size;i++){
                TreeNode* curr = q.front(); q.pop();
                if(curr->val > max)
                    max = curr->val;
                if(curr->left != nullptr)
                    q.push(curr->left);
                if(curr->right != nullptr)
                    q.push(curr->right);
            }
            result.emplace_back(max);
        }
        return result;
    }
};

// DFS
// Time Complexity : O(n)
// Space Complexity : O(h); h is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Level-order traversal with DFS but without maintaining array for full tree; Pass result vector as reference to recursive call instead
// 2. If the recursed level is equal to result array size, add node val to result (since visiting first time)
// 3. If not, compare current node val with the max val corresponding to that level in result and update max if reqd

class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        vector<int> result;
        dfs(root,result,0);
        return result;
    }
    
    void dfs(TreeNode* root, vector<int>& result, int level){
        // base
        if(root == nullptr)
            return;
        // logic
        if(level == result.size())
            result.emplace_back(root->val);
        else
            result[level] = max(result[level], root->val);
        dfs(root->left, result, level+1);
        dfs(root->right, result, level+1);
    }
};