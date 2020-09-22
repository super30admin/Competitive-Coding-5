// Time Complexity : O(n)
// Space Complexity : O(logn)
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1. Traverse and first add value at each level. 
//2. Update with max value
//3. Return the result
class Solution {
public:
    vector<int> result;
    vector<int> largestValues(TreeNode* root) {
        if(root==NULL)
            return result;
        dfs(root, 0);
        return result;
    }
    
    void dfs(TreeNode* root, int level){
        //return
        if(root==NULL)
            return;
        //logic
        if(result.size()==level){
            result.push_back(root->val);
        }else{
            result[level] = max(result[level], root->val);
        }
        level=level+1;
        dfs(root->left, level);
        dfs(root->right, level);
    }
};
