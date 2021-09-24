# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


queue=[]
        result=[]
        if root is not None:
            queue.append(root)
        while queue:
            size=len(queue)
            maxi=-inf
            
            for i in range(size):
                elem=queue.pop(0)
                print(elem.val)
                if(elem.val>maxi):
                    maxi=elem.val
                if elem.left:
                    queue.append(elem.left)
                if elem.right:
                    queue.append(elem.right)
            result.append(maxi)
        return result