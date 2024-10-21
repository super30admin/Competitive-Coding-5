// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var largestValues = function(root) {
    let result = [];
    let queue = [root]; 

    //If root is null return empty result
    if(root === null) return result;
    while(queue.length !== 0) {
        //set max to -Infinity to be able to handle negative values in root node
        let max = -Infinity;
        //Store size to queue length since it will keep changing when we push left and right sub trees
        let size = queue.length;

        while(size !== 0) {
            let curr = queue.shift();
            if(curr.val > max) {
                max = curr.val;
            }
            if(curr.left !== null) {
                queue.push(curr.left);
            }
            if(curr.right !== null) {
                queue.push(curr.right);
            }
            size--;
        }
        result.push(max);
    }
    return result;
};