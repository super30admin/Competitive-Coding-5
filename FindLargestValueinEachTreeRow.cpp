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
        queue<TreeNode*> q; 
        vector<int> answer; 
        //sanity check
        if (root == nullptr) {
            return answer;
        } else {
            q.push(root); 
        }

        //level order traversal
        while (!q.empty()) {
            int size = q.size(); // size is the number of elements in the same level
            int maxi = INT_MIN;
            while (size--) {
                TreeNode *node = q.front();
                q.pop();

                maxi = max(maxi, node->val); 

                if (node->left) {
                    q.push(node->left);
                } 
                if (node->right) {
                    q.push(node->right);
                }
            }
            answer.push_back(maxi); 
        }

        return answer;
    }
};
