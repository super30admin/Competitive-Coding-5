//Time Complexity: O(n)
//Space Complexity: Size of Queue

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
        deque<TreeNode*> q; 

        if(root == nullptr) return {}; 

        result.push_back(root->val); // Level0

        if(root->left != nullptr) q.push_back(root->left);
        if(root->right != nullptr) q.push_back(root->right);

        while(!q.empty()) {
            int qSize = q.size(); 
            int localMax = INT_MIN; 

            while(qSize > 0) {
                TreeNode* node = q.front(); 
                q.pop_front(); 
                localMax = max(localMax, node->val);

                if(node->left != nullptr) q.push_back(node->left);
                if(node->right != nullptr) q.push_back(node->right);
                qSize--; 
            }

            result.push_back(localMax);
        }

        return result; 

    }
};