// Time Complexity : O(M*N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: BFS using queue.

// 515. 

#include <bits/stdc++.h>
using namespace std;

 // Definition for a binary tree node.
  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };

class Solution
{
public:
    vector<int> largestValues(TreeNode *root)
    {
        vector<int> result;
        if (!root)
            return {};
        queue<TreeNode *> q;
        q.push(root);
        int level = 0;
        while (!q.empty())
        {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++)
            {
                auto curr = q.front();
                q.pop();

                if (result.size() == level)
                {
                    result.push_back(curr->val);
                }
                else
                {
                    if (result[level] < curr->val)
                        result[level] = curr->val;
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
            level++;
        }
        return result;
    }
};