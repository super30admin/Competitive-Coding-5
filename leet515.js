Using recrusively approach

Time complexity : O(N)
 Space complexity: O(N)

function largestValues(root) {
    if (!root) return [];
    let result = [];
    
    function traverse(node, level) {
        if (result[level] === undefined) {
            result.push(node.val);
        } else if (node.val > result[level]) {
            result[level] = node.val;
        }
        
        if (node.left) {
            traverse(node.left, level + 1);
        }
        if (node.right) {
            traverse(node.right, level + 1);
        }
    }
    
    traverse(root, 0);
    
    return result;
};