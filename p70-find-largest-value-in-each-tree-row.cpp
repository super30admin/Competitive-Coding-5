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

// Using BFS

// Time complexity is O(n)
// Space complexity is O(n) max queue size would be n/2 when all leaf nodes are present.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        if(root == nullptr) return {};
        vector<int> res;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            int size = q.size();
            int maxVal = INT_MIN;
            for(int i = 0; i < size; i++) {
                TreeNode* currNode = q.front();
                q.pop();
                maxVal = max(maxVal, currNode->val);
                if(currNode->left) q.push(currNode->left);
                if(currNode->right) q.push(currNode->right);
            }
            res.push_back(maxVal);
        }
        return res;
    }
};

// Using DFS
// Time complexity is O(n)
// Space complexity is O(h) recursive stack size max. value of h = n. (skewed tree).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
public:
    vector<int> res;
    void dfs(TreeNode* node, int level) {
        //base
        if(node == nullptr) return;
        
        //logic
        if(level == res.size()) {
            res.push_back(node->val);
        }
        else {
            res[level] = max(res[level], node->val);
        }
        dfs(node->left, level+1);
        dfs(node->right, level+1);
    }
    
    vector<int> largestValues(TreeNode* root) {
        dfs(root, 0);
        return res;
    }
};
