// https://leetcode.com/problems/find-largest-value-in-each-tree-row/
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//BFS
class Solution {
    public:
        vector<int> largestValues(TreeNode* root) {
            if(root == NULL) return {};
            queue<TreeNode*> q;
            vector<int> ans;
            q.push(root);
            while(!q.empty()){
                int s = q.size();
                int largest=INT_MIN;
                for(int i=0; i<s; i++){
                    TreeNode* curr = q.front();
                    q.pop();
                    if(curr != NULL) largest = max(largest, curr->val);
                    if(curr->left) q.push(curr->left);
                    if(curr->right) q.push(curr->right);
                }
                ans.push_back(largest);
            }
            return ans;
        }
    };


//DFS
// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree

class Solution {
    public:
        void dfs(TreeNode* root, vector<int> &res, int level){
            if(!root) return;
            if(level >= res.size()) res.push_back(root->val);
            else res[level] = max(res[level], root->val);
    
            dfs(root->left, res,level+1);
            dfs(root->right, res, level+1);
        }
        vector<int> largestValues(TreeNode* root) {
            if(root == NULL) return {};
            vector<int> res;
            dfs(root, res, 0);
            return res;
        }
    };