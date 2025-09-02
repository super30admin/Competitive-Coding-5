#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
/*
We use BFS to track each value at each level and choose the maximum value from it and store it 
in a result vector then we return the result
*/
class Solution{
public:
    vector<int> greatestValue(TreeNode* root){
        vector<int> result;
        if(!root) return result;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            int max_val = INT_MIN;
            for(int i=0; i<size; i++){
                TreeNode* curr = q.front(); q.pop();
                max_val = max(max_val, curr->val);
                if(curr->left) q.push(curr->left);
                if(curr->right) q.push(curr->right);
            }
            result.push_back(max_val);
        }
        return result;
    }
};
