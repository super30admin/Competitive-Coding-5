//
//  HeightBalancedBinaryTree.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/3/26.
//

class HeightBalancedBinaryTree {
    
    init() {
        
    }
    
    /*
    time compelxity - At first level - time is O(n) to check if it is balanced.
    at level 2 -> having 2 nodes (left and right) -> O(n/2) at the left side. O(n/2) at the right side. for completely balanced tree. So total - O(n)
    at level 3 - n/4 for all 4 -> total, O(n)
    next - N/8, n/8.... 8 times- > O(n)
    at level first, we are calculating the height
    at level second also, we are calculating the height again.
    total time taken -> O(n logn) - log n n is height of binary tree
    from parent to child. First we did it for parent. If it's balanced, then again called left and right children of it to find the height and check if it's balanced.
    */
    func isBalanced(_ root: TreeNode?) -> Bool {
        guard let root = root else {
            return true
        }
        //find height of left and right tree. If the dufference between left and right subtree height is greater than 1 then it is not balanced, else, it is balanced
        //check if root is balanced or not
        let leftH = heightOf(node: root.left)
        let rightH = heightOf(node: root.right)
        if (abs(leftH - rightH) > 1) {
            return false
        }
        //if root is balanced, it doesn't mean that all nodes in the whole tree is balanced. To check that, make sure that left child and right child both are balanced.
        //it will call height function for each and every node inside the tree and checking if it is balanced or not.
        return isBalanced(root.left) && isBalanced(root.right)
    }

    private func heightOf(node: TreeNode?) -> Int {
        guard let node = node else {
            return 0
        }
        let leftH = heightOf(node: node.left)
        let rightH = heightOf(node: node.right)
        return max(leftH, rightH) + 1
    }
    
    /*
     bottom up approach - better one
     O(n) traversal of tree
     we will provide to tha parent if the children is balanced or not. If child node is not balanced, return -1 to the parent. If left or right node is balanced, then it will be giving to it's parent the actual height.
     If either left or right is giving back -1, it means somewhere down, the tree is not balanced. It means whole tree is not balanced,
     */
    func isBalancedUsingBottomUp(_ root: TreeNode?) -> Bool {
        guard let root = root else {
            return true
        }
        return heightUsingBottomUp(root: root) != -1
    }

    private func heightUsingBottomUp(root: TreeNode?) -> Int {
        guard let root = root else {
            return 0
        }

        let lH = heightUsingBottomUp(root: root.left)
        let rH = heightUsingBottomUp(root: root.right)
        if (abs(lH - rH) > 1) {
            return -1
        }
        if (lH == -1 || rH == -1) {
            return -1
        }
        return max(lH, rH) + 1
    }

}
