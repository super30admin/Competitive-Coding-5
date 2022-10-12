// https://leetcode.com/problems/find-largest-value-in-each-tree-row/

// BFS
// Time Complexity : O(n)
// Space Complexity : O(n)

// DFS
// Time Complexity : O(n)
// Space Complexity : O(h)

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
let result;

let dfs = (root, height) => {
    // Base case
    if (root === null)
        return;

    // Logic
    if (result.length === height) {
        result.push(-Infinity);
    }
    result[height] = Math.max(result[height], root.val);

    dfs(root.left, height + 1);
    dfs(root.right, height + 1);
}
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var largestValues = function (root) {
    if (root === null)
        return [];

    result = [];
    // DFS
    dfs(root, 0);

    // BFS
    // Queue to maintain all the tree nodes
    //     let q = [];
    //     let result = [];
    //     q.push(root);

    //     while(q.length > 0){
    //         let size = q.length;
    //         let max = -Infinity;
    //         for(let i=0; i<size; i++){
    //             let node = q.shift();
    //             max = Math.max(max, node.val);
    //             if(node.left !== null) q.push(node.left);
    //             if(node.right !== null) q.push(node.right);
    //         }
    //         result.push(max);
    //     }

    return result;
};