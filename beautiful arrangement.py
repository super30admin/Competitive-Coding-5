
#// Time Complexity : O(N!) 
# // Space Complexity : Recursion stack 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.
class Solution:
    def countArrangement(self, n: int) -> int:
        visited=set()

        count = 0
        def helper(i):
            nonlocal count
            if  len(visited) % i != 0 and i % len(visited) != 0:
                return 
            if len(visited) == n:
                count += 1
                return
            
            for i in range(1,n+1):
                if i not in visited:
                    visited.add(i)
                    helper(i)
                    visited.remove(i)
            
        helper(1)
        return count

# Approach:
# The problem can be solved using backtracking. We start by selecting the first number and then recursively try
#     to select the next number. We use a set to keep track of the numbers that have been selected
#     We check if the current number can be selected by checking if the number of selected numbers is divisible
# by the current number and vice versa. If it is not possible to select the current number,
# we backtrack and try the next number.
