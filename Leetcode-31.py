'''
Leetcode:- 31 Next Permutation

Approach :- 

* From Right find the First Decreasing Element and the element found the pivot
* Swap that number with a number just greater than it from its right
* Reverse the Right part of number to get smallest possible combination of right right of pivot 

Worst case no pivot found reverse entire array (pivot=-1)    Eg:-  3 2 1 to 1 2 3

Eg : -
        8 2 1 6 4 3 2 1
            p           ----> Step 1 Find Pivot
        8 2 2 6 3 3 1 1 ----> Swap p with element just greater than pivot (x)
            p       x
        8 2 2 1 1 3 3 6 -----> Reverse Right of p

'''
# Time Complexity :- O(n) Max 2 pass
# Space Complexity :-O(1)

class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        def reverse(nums,k):
            left=k
            right=n-1
            while(left<right):
                nums[left],nums[right] = nums[right],nums[left]
                left+=1
                right-=1
            return(nums) 

        pivot=-1
        n=len(nums)
        for i in range(n-1,0,-1):
            if(nums[i]>nums[i-1]):
                pivot = i-1
                just_big = 101
                for j in range(pivot+1,n):
                    if(nums[j] > nums[pivot] and nums[j]<=just_big):
                        just_big,new = nums[j],j
                
                nums[pivot],nums[new] = nums[new],nums[pivot] 
                break
        return(reverse(nums,pivot+1))