// Time Complexity : O(n) where n in number of element in a tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was not able to complete the code duing mock interview but was able to finish the code after the interview.

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
    if(!root) return [];
    let queue = [];
    let result = [];
    queue.push(root);
    while(queue.length) {
        const length = queue.length;
        let max = -Infinity;
        for(let i = 0; i < length; i++) {
            let curr = queue.shift();
            if(curr.left !== null) queue.push(curr.left);
            if(curr.right !== null) queue.push(curr.right);
            max = Math.max(max,curr.val);
        }
        result.push(max);
    }
    return result;
};