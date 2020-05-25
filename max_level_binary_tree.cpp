//Time Complexity-O(n)
//Space Complexity-O(height) and O(breadth)
//Ran successfully on leetcode

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
    /*vector<int> largestValues(TreeNode* root) {
        //base case
        if(root==NULL)
            return {};
        vector<int>result;
        queue<TreeNode*>q;
        q.push(root);
        while(!q.empty())
        {
            int maximum=INT_MIN;
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                TreeNode*curr=q.front();
                int x=curr->val;
                q.pop();
                if(x>maximum)
                    maximum=x;
                if(curr->left!=NULL)
                    q.push(curr->left);
                if(curr->right!=NULL)
                    q.push(curr->right);
            }
            result.push_back(maximum);
        }
        return result;
    }*/
    vector<int> largestValues(TreeNode* root) {
        //base case
        if(root==NULL)
            return {};
        vector<int>result;
        dfs(root,result,0);
        return result;
    }
    void dfs(TreeNode* root,vector<int>&result,int depth)
    {
        if(root==NULL)
            return;
        if(depth>=result.size())
            result.push_back(root->val);
        else
            result[depth]=max(result[depth],root->val);
        dfs(root->left,result,depth+1);
        dfs(root->right,result,depth+1);
    }
};