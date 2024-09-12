// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var largestValues = function(root) {
    let q = [root];
    let res = [];
    
    if(!root) return []; 
    while(q.length > 0){
        let size = q.length
        let max = Number.MIN_SAFE_INTEGER;
        
        for(let i = 0; i < size; i++){
            let curr = q.shift();
            if(curr.val > max){
                max = curr.val
                console.log(max)
            }
            if(curr.left != null){
            q.push(curr.left)
            }
            if(curr.right != null){
                q.push(curr.right)
            }
        }
        
        res.push(max)
    }
    return res
};