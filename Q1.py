######### Greatest value in each level

# Time Complexity : O(n)
# Space Complexity : O(h) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# perform a dfs and keep track of the level. Based on the level add the value and keep taking the max

def find_greatest_of_level(root):
        if not root:
            return []
        
        stack = [(root,0)]
        result = []
        while stack:
            node, level = stack.pop()
            if level == len(result):
                result.append(node.val)
            else:
                result[level] = max(result[level],node.val)
            
            if node.left:
                stack.append((node.left,level+1))
            if node.right:
                stack.append((node.right,level+1))
        return result

