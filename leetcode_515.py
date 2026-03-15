#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 515: Find Largest Value in Each Tree Row
    Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/

    Problem:
    Given the root of a binary tree, return an array of the largest value in
    each row of the tree.

    Approach:
    BFS with a None delimiter to mark level boundaries. Track the running max
    for each level; when the delimiter is encountered, append the max to results
    and reset for the next level.

    1️⃣ Seed queue with root followed by None delimiter.
    2️⃣ While queue has more than one element (the trailing None), dequeue nodes.
    3️⃣ On a real node: update maxv, enqueue children.
    4️⃣ On None delimiter: append maxv to results, reset maxv, append a new None.
    5️⃣ Append the final maxv after the loop (last level has no trailing None).

    // Time Complexity : O(n)
        Every node is visited once.
    // Space Complexity : O(n)
        Queue holds at most O(n) nodes at a level.

"""

from typing import List, Optional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []

        res = []
        queue = []
        queue.append(root)
        queue.append(None)
        maxv = float('-inf')

        while len(queue) > 1:
            x = queue.pop(0)
            if x is not None:
                if x.val > maxv:
                    maxv = x.val
                if x.left:
                    queue.append(x.left)
                if x.right:
                    queue.append(x.right)
            else:
                res.append(maxv)
                maxv = float('-inf')
                queue.append(None)

        res.append(maxv)
        return res
