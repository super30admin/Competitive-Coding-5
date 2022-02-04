/**
 * Time Complexity:
 * O(N) where N is nodes of the tree. We are traversing through the tree only once.
 */


/**
 * Space Complexity:
 * The space complexity will be O(N) where n is the number of nodes as we are maintaining a queue 
 * to help in calculations.
 */


/**
 * Approach:
 * The first intution that comes in the mind to find the largest value in a row of tree is
 * level order traversal. We have to iterate in each row of the tree and keep updating the max value for that row.
 * We maintain a queue for this and start with pushing the root in the queue. until the queue is empty we keep on checking
 * the children of the root, if there are children we keep on pushing them to the queue and simultaneously also keep
 * updating the maxval. Everytime we see the front element of the queue and we compare its value with the max. To take care
 * of the negattive values we initialize our max val to minimum int value. We are maintaining the size of the queue because
 * it helps us in performing operation on each level. When we get our max value we push into resultant vector
 * and move on to the next level.
 * 
 */

//The code ran perfectly on leetcode.


class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        if(root== NULL) return {};
        queue<TreeNode*> q;
        q.push(root);
        vector<int> result;
        
        while(q.empty() == false){
            int size = q.size();
            int maxVal = INT_MIN;
            for(int i =0; i<size; i++){
                TreeNode *curr = q.front();
                q.pop();
                if(curr->left) q.push(curr->left);
                if(curr->right) q.push(curr->right);
                maxVal = max(maxVal, curr->val);
            }
            result.push_back(maxVal);
        }
        
        return result;
        
    }
};