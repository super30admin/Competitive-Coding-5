# TC & SC: O(n)
# Very similar to level order traversal. Here we use a aux variable to compare queue elements at particular level to store max of those to a result array. Do the same for all levels. 

from collections import deque
class Solution:
    def largestValues(self, root):
        if root == None: return []
        result = []
        q = deque()
        q.append(root)
        while q:
            # size at each level is important as we need to segregate level elements to compute max of it
            size = len(q)
            temp = float('-inf')      
            for i in range(size):
                curr = q.popleft()
                temp = max(temp, curr.val)
                if curr.left : q.append(curr.left)
                if curr.right: q.append(curr.right)
            result.append(temp)
        return result