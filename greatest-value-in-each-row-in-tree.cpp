/*Use a level-order traversal (BFS) to iterate through each level of the binary tree, tracking the maximum value at each level.
For each level, update the maximum value while enqueuing child nodes and populate the result vector with the maximum values per level.
Return the vector containing the maximum values at each level of the binary tree.

Time Complexity: O(N), where N is the number of nodes in the binary tree, as each node is visited once during the BFS traversal.
Space Complexity: O(W), where W is the maximum width of the tree (width is the number of nodes on the level with the most nodes). In the worst case, the queue can store all nodes at the widest level.*/
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

#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        if(root==nullptr){
            return vector<int>{};
        }
        vector<int>ans;
        queue<TreeNode*>queue;
        queue.push(root);
        while(!queue.empty()){
            int currLength=queue.size();
            int currMax=INT_MIN;
            for(int i=0;i<currLength;i++){
                TreeNode* node=queue.front();
                queue.pop();
                currMax=max(currMax,node->val);
                if(node->left){
                    queue.push(node->left);
                }
                if(node->right){
                    queue.push(node->right);
                }
            }
            ans.push_back(currMax);
        }
        return ans;
    }
};