// Time Complexity                              :  O(N)
// Space Complexity                             :  O(N) asymptotically. Maximum would be the maximums of all the 2*2^h from the root. 
//                                                 Since we are using a local vector also in this case it will add to the space complexity.
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/

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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        
        if(!root) return ans;
        
        queue<TreeNode*> q;
        q.push(root);
        bool reverseVector = false;
        while(!q.empty()) {
            int sz = q.size();
            vector<int> localVector;
            for(int i=0;i<sz;i++) {
                TreeNode *ctop = q.front();
                q.pop();
                localVector.push_back(ctop->val);
                if(ctop->left) q.push(ctop->left);
                if(ctop->right) q.push(ctop->right);
            }
            
            if(reverseVector == true) {
                reverse(begin(localVector),end(localVector));
                reverseVector = false;
            } else {
                reverseVector = true;
            }
            
            ans.push_back(localVector);
        }
        
        return ans;
    }
};