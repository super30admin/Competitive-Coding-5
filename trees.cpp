// Time Complexity : O(n)
// Space Complexity : O(h) = O(n) (in case of skewed tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Start DFS from root
// At each node, check the size of the result vector
// If size == level, push the root value into the vector, otherwise, replace with max(result[level], root->val)

class Solution {
private:
    void dfs(TreeNode* root, int level, vector<int>& result) {
        // base:
        if(!root) return;

        // logic:
        if(result.size() == level) { // we are coming to this level for the first time
            result.push_back(root->val);
        } else {
            result[level] = max(result[level], root->val);
        }

        dfs(root->left, level + 1, result);
        dfs(root->right, level + 1, result);
    }
public:
    vector<int> largestValues(TreeNode* root) {
        vector<int> result;
        dfs(root, 0, result);
        
        return result;
    }
};