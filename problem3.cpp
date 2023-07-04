#include<iostream>
#include<vector>
#include<queue>

using namespace std;



struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        vector<int> sol{};
        queue<TreeNode*> que;
        if(root) que.push(root);
        while(!que.empty()){
            int n = que.size();
            int max{};
            for(int i{};i<n;++i){
                TreeNode* node = que.front();
                if(i==0){
                    max = node->val;
                }
                else{
                    if(node && max<node->val) max = node->val;
                }
                if(node->left) que.push(node->left);
                if(node->right) que.push(node->right);
                que.pop();
            }
            sol.push_back(max);
        }
        return sol;
    }
};