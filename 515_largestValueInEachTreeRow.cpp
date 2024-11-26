// Time Complexity : O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//DFS
class Solution {
public:
    vector<int> result;
    vector<int> largestValues(TreeNode* root) {
        if(root == NULL){
            vector<int> x;
            return x;
        }
        dfs(root,0);
        return result;
    }
    void dfs(TreeNode* root, int level){
        //base
        if(root == NULL){
            return;
        }
        //logic
        
        if(result.size()<=level){
            result.push_back(root->val);
        }
        int x = result[level];
        result[level] = max(x,root->val);
        dfs(root->left, level+1);
        dfs(root->right, level+1);
    }
};

// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//BFS
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        if(root == NULL){
            vector<int> x;
            return x;
        }
        queue<TreeNode*> q;
        vector<int> result;
        q.push(root);
        
        while(!q.empty()){
            int size = q.size();
            int Max = INT_MIN;
            for(int i=0; i<size; i++){
                TreeNode* curr = q.front();
                q.pop();
                Max = max(Max,curr->val);
                if(curr->left != NULL)
                    q.push(curr->left);
                if(curr->right != NULL)
                    q.push(curr->right);
            }
            result.push_back(Max);
        }
        return result;
    }
};
