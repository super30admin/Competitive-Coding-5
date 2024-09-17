# Time Complexity: O(N) for going through all nodes in the tree
# Space Complexity: O(H) as we go upto the height of the tree (worst case O(N))
# Did this run successfully on leetcode: Yes
# Any problems faced in this question: No
# Explain the approach:

# if the lenght of the result array is equal to the level, that means
# there is no element present yet at that position
# so we append that element to the result array, 
# but if there is an element present at that position, 
# then compare it with root, and put the maximum element at that position
# in the end return the result array

class Solution:

    def largestValues(self, root):

        result = []
        if root is None:
            return result
        
        def helper(root, level, result):

            if root is None:
                return
            
            if level == len(result):
                result.append(root.val)
            else:
                if root.val > result[level]:
                    result[level] = root.val
            helper(root.left, level+1, result)
            helper(root.right, level+1, result)
        
        helper(root, 0, result)
        return result