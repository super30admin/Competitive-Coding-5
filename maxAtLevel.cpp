/*

Intuition: Getting the maximum at each level by keeping a track of a max variable.
For DFS, a result can be put into the result array using the level. 
/////////////////////////
BFS Solution
Time Complexity: O(N), N = Number of nodes 
Space Complexity: O(N/2), N/2 = Number of leaf nodes
DFS Solution
Time Complexity: O(N), N = Number of nodes 
Space Complexity: O(H), H = height of the tree
*/
//BFS
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        
        vector <int > result;

        if (root == NULL) return result;
        queue <TreeNode*> queue;
        queue.push(root);
        
        while(queue.size() != 0){
        
            int size = queue.size();
            int currentMax = INT_MIN;	
            
            for ( int i = 0 ; i < size; i++){
            
                TreeNode* currentNode = queue.front();
                queue.pop();
                
                if (currentMax < currentNode->val){
                    currentMax = currentNode->val;
                }
                
                if (currentNode->left != NULL) queue.push(currentNode->left);
                if (currentNode->right != NULL) queue.push(currentNode->right);
                
            }
            result.push_back(currentMax);
        }
        return result;

    }
};

//DFS
class Solution {
public:
    vector <int > result;

    vector<int> largestValues(TreeNode* root) {
        

        if (root == NULL) return result;
        dfs(root, 0);
        return result;

    }
    
    void dfs(TreeNode* root, int level){
        
        //Base
        if (root == NULL) return;
        
        if (level == result.size()){
            result.push_back(root->val);
        }
        else{
            result[level] = max(result[level], root->val);
        }
        dfs(root->left, level + 1);
        dfs(root->right, level + 1);
    }

};