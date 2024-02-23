// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// use level order traversal and at each level we store only the max value in our result array.

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
class Solution
{
public:
    vector<int> largestValues(TreeNode *root)
    {
        if (root == NULL)
            return {};
        queue<TreeNode *> q;
        q.push(root);
        vector<int> result;
        int lvl = 0;
        while (!q.empty())
        {
            int n = q.size();
            while (n--)
            {
                TreeNode *curr = q.front();
                q.pop();
                if (lvl == result.size())
                {
                    result.push_back(curr->val);
                }
                else
                {
                    if (curr->val > result[lvl])
                    {
                        result[lvl] = curr->val;
                    }
                }
                if (curr->left != NULL)
                {
                    q.push(curr->left);
                }
                if (curr->right != NULL)
                {
                    q.push(curr->right);
                }
            }
            lvl++;
        }
        return result;
    }
};