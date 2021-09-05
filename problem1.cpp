//Time Complexity - O(n)
//Space Complexity - O(n)
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        vector<int>ans;
        if(root==NULL)
            return ans;
        queue<TreeNode*>q;
        q.push(root);
        int m = INT_MIN;
        while(!q.empty()){
            int n = q.size();
            while(n--){
                if(q.front()->left)
                    q.push(q.front()->left);
                if(q.front()->right)
                    q.push(q.front()->right);
                if(m<q.front()->val)
                    m=q.front()->val;
                q.pop();
            }
            ans.push_back(m);
            m=INT_MIN;
        }
        return ans;
    }
};