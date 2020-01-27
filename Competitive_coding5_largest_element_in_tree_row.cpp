// Time Complexity : O(nodes)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        //edge case
        if(!root) return {}; //if empty tree simply return
        
        vector<int> v; //vector which stores the max values of every row
        queue<TreeNode*> q; //queue to store values of BT if every level
        q.push(root); //add the root node to the queue
        
        
        while(!q.empty()){ //run loop till queue is empty
            int max=-9999; //initialize MAX to min value
            int SIZE = q.size();
            for(int i=0;i<SIZE;i++)   //iterate loop till queue size
            { TreeNode *elem = q.front(); //elem points to the front value of q
                
                if(max<=elem->val)  //compare max with current elem->val
                    max=elem->val;
                if(elem->left!=NULL)    
                    q.push(elem->left);     //push left child if avail
                if(elem->right!=NULL)
                    q.push(elem->right);    //push right child if avail
             q.pop();                       //pop elements from q after processing
            }
            v.push_back(max);               // push maximum element of row into vector
        }
        return v;                   //return vector containing max values
        
    }
    
   
};