'''
Leetcode:- 40 Combination Sum II

Approach :- 

* Sort the Candidates array (The idea behind is to iterate and skip elements in array to find next distinct element )
* Use 0 1 Recursion to find combinations of target along with path 
* Backtrack that path once it comes back to parent 
* While non choose case make sure your pointer(i) points to next distinct integer and not very next index (Thats why we sorted !!!)
* Base case when target becomes deep copy the path to result.

'''
# Time Complexity :- O(2^n)
# Space Complexity :-O(n) Recursive Stack

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        
        candidates.sort()
        result=[]

        def backtrack(i,candidates,target,result,path):
            if(target==0):
                result.append(copy.deepcopy(path))   # When target == 0 Copy the path to array 
                return
            if(i>=len(candidates) or target<0): 
                return
            
            path.append(candidates[i]) # Action
            backtrack(i+1,candidates,target-candidates[i],result,path) # Choose
            path.pop() # Backtrack

            for k in range(i+1,len(candidates)):  # Find next distict integer 
                if(candidates[k]!=candidates[i]):
                    backtrack(k,candidates,target,result,path) # Dont Choose 
                    break
            return
        
        backtrack(0,candidates,target,result,[])
        return(result)
