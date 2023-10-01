// Time Complexity :O(n);
// Space Complexity :O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
/*
In this solution, we first traverse the binary tree. While traversing we keep track of the level of the tree and
the maximum of each level and store the maximums in the vector. We can do this with the help of bFS/DFS but in this solution
I chose BFS. iN BFS illbe traversing level by level and maintain a max variable for each level and insert into
the result vector and return the result.



*/

// Your code here along with comments explaining your approach
/**
 * 
 * 
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
    vector<int> largestValues(TreeNode* root) {

        
        vector<int> result;
        queue<TreeNode*> q;
        int level=0;
        int max;
        if(root==NULL){
            
            return result;
            

        }

        

        q.push(root);

        while(!q.empty()){
            int size=q.size();
            max=INT_MIN;
            

            for(int i=0;i<size;i++){
                TreeNode* curr = q.front();
                q.pop();
                if(curr->left != NULL){
                    q.push(curr->left);
                }
                if(curr->right!=NULL){
                    q.push(curr->right);
                }

                if(curr->val > max){
                    max = curr->val;

                }




               


            }
            result.push_back(max);
            level++;
        }
        return result;

        
    }
};