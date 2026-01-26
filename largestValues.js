/**
 * @param {TreeNode} root
 * @return {number[]}
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 * Intuition:
 To find the largest value in each level of the binary tree, we perform a depth-first traversal while keeping track of the   current level. As we visit each node, we compare its value with the maximum stored for that level and update it if necessary. If a level has not been visited before, we initialize its value to negative infinity. By propagating the level index during recursion, we ensure that all nodes at the same depth contribute to the same result entry. After traversing the entire tree, the result array contains the maximum value for each level.
 T.C: O(n)
 S.C: O(h) // depth of the tree
 */
// dfs
var largestValues = function (root) {
    const res = [];
    let level = 0;

    const dfs = (node, level) => {
        // base
        if (!node) return;
        // action
        if (!res[level] && res[level] !== 0) res[level] = -Infinity;
        if (res[level] < node.val) res[level] = node.val;

        // recursion
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    // dfs call
    dfs(root, 0);
    return res;
};

// bfs
/**
 * @param {TreeNode} root
 * @return {number[]}
 *  Intuition:
We traverse the tree level by level using breadth-first search. 
For each level, we process all nodes currently in the queue and track the maximum value among them. 
Before moving to the next level, we store this maximum in the result array.
By pushing each node’s children into the queue, we ensure that all nodes at the same depth are processed together, allowing us to correctly compute the largest value for every level.

T.C: O(n)
S.C: O(n/2) => O(n)

 */
var largestValues = function(root) {
    // bfs
    if(!root) return [];
    const queue = [root];
    const res = [];
    let level = 0;
    while(queue.length){
     const levelLength = queue.length;
     for(let i = 0; i< levelLength; i++){
        const node = queue.shift();
        if(!res[level] && res[level] != 0) res[level] = -Infinity;
        res[level] = Math.max(res[level], node.val);
        if(node.left) queue.push(node.left);
        if(node.right) queue.push(node.right);
     }
     level++;
    }
   return res;
};