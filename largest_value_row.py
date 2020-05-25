# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Main idea:
We traverse the tree in a pre-order fashion. Everytime
we encounter a node, we check if it's level is equal to the length
of the result array (meaning first time we encounter this level).
if it is, we append the value, if it's not, we change the value
in the res array to the max between the node value and what's
in the res array at that index.
'''
#Problem 1: Find Largest Value in Each row
#time complexity: O(n)
#Space complexity O(h) , height of the tree
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        #edge case
        if not root:
            return []

        st=[]
        res=[]
        depth=0
        while st or root:
            while root:

                st.append((root,depth))
                if depth==len(res):
                    res.append(root.val)
                else:
                    res[depth]=max(root.val,res[depth])

                root=root.left
                depth+=1

            root,depth=st.pop()
            root=root.right
            depth+=1

        return res

#time complexity: O(n)
#Space Complexity: O(n) , size of the queue.
'''
Main idea:
We traverse the tree level by level (BFS), while keeping
track of the length of queue so we can process
generation by generation. During each generatin, we
have a local maximum and we update accrodingly with the
root values as we pop them. At the end of the generation
we append them to the res array.

'''
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        #edge case
        if not root:
            return []

        queue=collections.deque()
        queue.append(root)
        res=[]
        while queue:
            size=len(queue)
            n=0
            max_=float("-inf")
            while queue and n<size:
                curr=queue.popleft()
                n+=1
                if curr.val>max_:
                    max_=curr.val
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            res.append(max_)
        return res
