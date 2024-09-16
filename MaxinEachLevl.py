#time complexity: O(n)
#space complexity: O(h)
class Solution:
    result = []
    maxm = (-2**31)-1
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        q = deque()
        q.append(root)
        self. result = []
        self.maxm = (-2**31)-1
        while q:
            self.maxm = (-2**31)-1
            for i in range(len(q)):
                el = q.popleft()
                if el.val>self.maxm:
                    self.maxm = el.val
                if el.left != None:
                    q.append(el.left)
                if el.right != None:
                    q.append(el.right)
            self.result.append(self.maxm)
        return self.result