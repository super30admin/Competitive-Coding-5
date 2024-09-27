//Que : Find largest value in each tree row 
//(https://leetcode.com/problems/find-largest-value-in-each-tree-row/)
//TC- O(n) as traverse all nodes 
//SC- O(h)
//Idea - DFS 


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
    
    vector<int> result ;
    vector<int> largestValues(TreeNode* root) {
        
        if(root==NULL){
            return result;
        }
        
        dfs(root, 1);
        return result;
        
    }
    
    void dfs( TreeNode* root, int level){
        
        //base
        if(root==NULL){
            return;
        }
        
        if(result.size() < level){
            result.push_back( root->val);
        }
        else{
            if( result[level-1] < root->val){
                result[level-1] = root->val;
            }
        }
        
        //rec
        dfs( root->left, level+1);
        dfs(root->right, level+1);
    }
};


//Que : Find largest value in each tree row 
//(https://leetcode.com/problems/find-largest-value-in-each-tree-row/)
//TC- O(n) as traverse all nodes 
//SC- O(n) as use a queue
//Idea - do level order traversal (BFS)
//could be implemented 
