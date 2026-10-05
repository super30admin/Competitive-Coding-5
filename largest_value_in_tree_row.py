'''
515 Find Largest Value In Each Tree Row
https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).


Example 1:
Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]

Example 2:
Input: root = [1,2,3]
Output: [1,3]


Constraints:
The number of nodes in the tree will be in the range [0, 104].
-2^31 <= Node.val <= 2^31 - 1

Solution:
1. BFS
Time: O(N), Space: O(N/2)
'''
from binary_tree import *

def max_in_tree_row(root):
    if not root:
        return []

    q = deque()
    q.append(root)
    result = []
    while q:
        K = len(q)
        Mx = -float('inf')
        for _ in range(K):
            curr = q.popleft()
            Mx = max(Mx, curr.val)
            if curr.left:
                q.append(curr.left)
            if curr.right:
                q.append(curr.right)
        result.append(Mx)
    return result

def run_tests():
    tests = [ ([1,3,2,5,3,None,9], [1,3,9]),
              ([5,4,8,11,None,13,4,7,2,None,None,5,1], [5,8,13,7]),
    ]
    for test in tests:
        root, ans = test[0], test[1]
        tree=build_tree_level_order(root)
        tree.display() if tree else None
        res = max_in_tree_row(tree)
        print(f"\nroot = {root}")
        print(f"Max value in each row = {res}")
        passed = (ans == res)
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()