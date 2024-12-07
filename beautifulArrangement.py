# // Time Complexity :O(n!) for permutations
# // Space Complexity :O(n) array and recursion
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : Used / instead of %, used 2 counters 


# // Your code here along with comments explaining your approach
# Initialize an array of n consecutive integers. 
# Our recursion function will fix on a pivot location and swap with rest of the elements to get all permutations. 
# If our pivot reaches last element, its Beautiful.
# Eliminated 2nd counter after using nonlocal count
class Solution:
    def countArrangement(self, n: int) -> int:
        arr = [i+1 for i in range(n)]
        count = 0

        def helper(pivot:int):
            nonlocal count                                          # Eliminate 2nd counter

            if pivot == n:
                count+=1
                return

            # aCount = 0
            for i in range(pivot,n):
                if (pivot+1)%arr[i] == 0 or arr[i]%(pivot+1) == 0:  # use % instead of /
                    
                    arr[i],arr[pivot] = arr[pivot],arr[i]           # action -> swap temp
                    
                    helper(pivot+1)                                 # recursion
                    
                    arr[i],arr[pivot] = arr[pivot],arr[i]           # backtrack

        helper(0)
        return count 