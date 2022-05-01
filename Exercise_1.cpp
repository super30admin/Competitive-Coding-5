// Time Complexity                              :  O(N)
// Space Complexity                             :  O(N) asymptotically. maximum is maximum of all the 2^h where h is the height of the tree. 
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/find-largest-value-in-each-tree-row/submissions/

class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        vector<int> ans;
        if(!root) return ans;
        
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            int lmax = INT_MIN;
            int sz = q.size();
            for(int i=0;i<sz;i++) {
                TreeNode *ctop = q.front();q.pop();
                lmax = ctop->val > lmax ? ctop->val : lmax;
                if(ctop->left) q.push(ctop->left);
                if(ctop->right) q.push(ctop->right);
            }
            ans.push_back(lmax);
        }
        return ans;
    }
};