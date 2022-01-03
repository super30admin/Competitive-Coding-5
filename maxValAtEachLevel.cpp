//BFS:
    //Time complexity : O(n)
    //Space complexity : O(n/2) : O(n)

    //Approach:
            // Put all the nodes level wise in the queue
            // At each level, find max, after traversal of entire level, push the max in the resultant array

//DFS:
    //Time complexity : O(n)
    //Space complexity : O(h)

    //Approach: 
            // Recursively go through the left and right children
            // At each level, check whether the current element in the array at the index level is greater
            // Return the array


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
    vector<int> result;
    vector<int> largestValues(TreeNode* root) {
        if(root == nullptr)
            return {};
        
//         vector<int> result;
        
//         queue<TreeNode*> q;
        
//         q.push(root);
        
//         while(!q.empty())
//         {
//             int size = q.size();
//             int max = INT_MIN;
//             for(int i = 0 ; i < size; i++)
//             {
//                 TreeNode* ptr = q.front();
//                 q.pop();
                
//                 if(ptr->val > max)
//                 {
//                     max = ptr->val;
//                 }
                
//                 if(ptr->left)
//                     q.push(ptr->left);
//                 if(ptr->right)
//                     q.push(ptr->right);
//             }
//             result.push_back(max);
//         }
        
//         return result;
        
        dfs(root , 0);
        
        return result;
    }
    
    void dfs(TreeNode* root, int level)
    {
        if(root == nullptr)
            return;
        
        if(result.size() == level)
        {
            result.push_back(root->val);
        }
        
        if(root->val > result[level])
        {
            result[level] = root->val;
        }
        
        dfs(root->left, level + 1);
        dfs(root->right, level + 1);
    }
        
};