from collections import deque
import sys

class Solution:
	def largestValues1(self, root: TreeNode) -> List[int]:
		# BFS approach
		# Time Complexity : O(n) where n is the number of elements in the tree
		# Space Complexity : O(n) where n is the number of elements in the tree
		# Find the max value of every level and add it to the resultant array
		res = []
		if root == None:
			return res
		queue = deque()
		queue.append(root)
		while len(queue) > 0:
			size = len(queue)
			maxval = -sys.maxsize - 1 # Initially setting our max value to the most min element in python3
			for i in range(size):
				node = queue.popleft()
				if node.val > maxval: # compare the current node value in that level with the maxvalue for that level
					maxval = node.val
				if node.left != None:
					queue.append(node.left)
				if node.right != None:
					queue.append(node.right)
			res.append(maxval) # Finally append the max value to the resultant list
		return res

	def largestValues2(self, root: TreeNode) -> List[int]:
		res = []
		if root == None:
			return res
		queue = deque()
		queue.append(root)
		while len(queue) > 0:
			size = len(queue)
			firstNode = queue.popleft()
			maxval = firstNode.val # Instead of setting the most min value in python to be the max value we can set the first element in that level to the max value
			if firstNode.left != None: # After we pop off the first element we should add its children to the queue
				queue.append(firstNode.left)
			if firstNode.right != None:
				queue.append(firstNode.right)
			for i in range(size - 1): # Now verify only for range(size - 1) elements because the first element for that level is already made the maxval initially
				node = queue.popleft()
				if node.val > maxval:
					maxval = node.val
				if node.left != None:
					queue.append(node.left)
				if node.right != None:
					queue.append(node.right)
			res.append(maxval)
		return res

	def largestValues3(self, root: TreeNode) -> List[int]:
		# Time Complexity : O(n) where n is the number of elements in the tree
		# Space Complexity : O(n) where n is the number of elements in the tree
		res = []
		self.dfs(root, res, 1)
		return res

	def dfs(self, node, res, depth): # depth will tell which level we are in and which index to modify in the resultant array
		# base case
		if node == None:
			return
		if len(res) < depth: # if we haven't visited any node in that level we just directly append its value to the resultant array
			res.append(node.val)
		else: # if a value exist at depth - 1 index of res array, then we compare its current values with the node value and place the max of both in the array
			if res[depth - 1] > node.val:
				res[depth - 1] = node.val
		self.dfs(node.left, res, depth + 1) # call the same function for the left child by increasing the depth
		self.dfs(node.right, res, depth + 1) # Similarly call for the right child by increasing depth