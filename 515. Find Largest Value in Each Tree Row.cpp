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
    /*
    Time: O(n)
    Space: O(h) (h = height of the tree)

    Do BFS level by level, and track maximum for each level

    */
    vector<int> largestValues(TreeNode* root) {
        vector<int> ret;    
        if(root == nullptr)  return {};

        //BFS
        int level = 0;
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty()){
            queue<TreeNode*> tmp;
           
            while(!q.empty()){
                auto node = q.front();
                q.pop();
                
                if(ret.size()==level)  ret.push_back(node->val);
                else  ret[level] = max(ret[level], node->val);

                if(node->left != nullptr)  tmp.push(node->left);
                if(node->right != nullptr)  tmp.push(node->right);
                
            }

            level++;
            q = move(tmp);
        }

        return ret;
    }
};
