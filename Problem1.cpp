//
// Created by shazm on 8/4/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        vector<int> retVec;
        if(root==NULL){return retVec;}
        queue<TreeNode*> que;
        que.push(root);

        TreeNode* node; int size; int maxVal;
        while(!que.empty()){
            maxVal = INT_MIN;
            size = que.size();
            for(int x = 0; x<size; x++){
                node = que.front();
                if(node->val > maxVal){
                    maxVal = node->val;
                }
                if(node->left!=NULL){
                    que.push(node->left);
                }
                if(node->right!=NULL){
                    que.push(node->right);
                }
                que.pop();
            }
            retVec.push_back(maxVal);
        }
        return retVec;
    }
};