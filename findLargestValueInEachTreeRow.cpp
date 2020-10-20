//time complexity:O(n)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using bfs
//any issues faced? no

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
        vector<int>res;
        if(root==NULL)
            return res;
        
        queue<TreeNode*>q;
        if(root)
            q.push(root);
        while(!q.empty())
        {
            int max=INT_MIN;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode*curr=q.front();
                q.pop();
                if(curr->val>=max)
                    max=curr->val;
                if(curr->left)
                    q.push(curr->left);
                if(curr->right)
                    q.push(curr->right);
            }
            res.push_back(max);
        }
        return res;
    }
};