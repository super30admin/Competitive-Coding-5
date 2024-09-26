# Time Complexity : O(N)
# Space Complexity : O(N)

import collections

def largestValues(root):
    if root is None:
        return []

    result = []
    q = collections.deque()
    q.append(root)

    while q:
        qlen = len(q)
        high = -inf 
        for i in range(qlen):
            curr = q.popleft()
            high = max(high, curr.val)
            if curr.left is not None:
                q.append(curr.left)
            if curr.right is not None:
                q.append(curr.right)

        result.append(high)

    return result
