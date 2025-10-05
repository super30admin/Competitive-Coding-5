// Time Complexity : O(n)
// Space Complexity : O(n/2) ~ O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Here we can do BFS or DFS, for the BFS approach we take a queue of
// TreeNode*
// 2. We calculate the max at each level and push to the list
// 3. Once the queue is empty, we return our list

#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for a binary tree node.
 */
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right)
      : val(x), left(left), right(right) {}
};

class Solution {
public:
  // vector<int> res;
  vector<int> largestValues(TreeNode *root) {
    // dfs(root, 0);
    // return res;
    vector<int> res;
    if (!root)
      return res;
    queue<TreeNode *> q;
    q.push(root);
    while (!q.empty()) {
      int size = (int)q.size();
      int maxi = INT_MIN;
      for (int i = 0; i < size; i++) {
        TreeNode *front = q.front();
        q.pop();
        maxi = max(front->val, maxi);
        if (front->left)
          q.push(front->left);
        if (front->right)
          q.push(front->right);
      }
      res.push_back(maxi);
    }

    return res;
  }

  // void dfs(TreeNode *root, int level) {
  //   if (!root)
  //     return;
  //   if (res.size() == level) {
  //     res.resize(level + 1, INT_MIN);
  //   }
  //   res[level] = max(res[level], root->val);
  //   dfs(root->left, level + 1);
  //   dfs(root->right, level + 1);
  // }
};
