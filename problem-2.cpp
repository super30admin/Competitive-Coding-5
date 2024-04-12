// t-c: n
// s-c: n
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
        if(root == NULL)
            return {};
        vector<int> result;
        int max = INT_MIN;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                root = q.front();
                q.pop();
                if(root->val > max)
                        max = root->val;
                if(root->right != NULL)
                    q.push(root->right);
                if(root->left != NULL)
                    q.push(root->left);     
            }
            result.push_back(max);
            max = INT_MIN;  
        }
        return result;
    }
};
