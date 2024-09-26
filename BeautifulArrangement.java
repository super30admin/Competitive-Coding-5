//Time: O(m) -> m is num of beautiful permutations
//Space: O(n) -> n recursive calls for n integers

class Solution {
    //global count to monitor beautiful arrangements
    int count;

    public int countArrangement(int n) {
        // creating a list of numbers from n
        List<Integer> nums = new ArrayList<>();
        for(int i =1; i<=n; i++) {
            nums.add(i);
        }
        
        countBeatifulPerms(nums , 0);
        return count;
    }
    
    void countBeatifulPerms(List<Integer> nums, int index) {
        int n = nums.size();
        
        //when index==size of nums
        //we have encountered end of pattern
        //increment count
        if(index == n) {
            count++;
        }
        
        for(int i=index; i<n; i++) {
            //swap num at i and index to form permutation
            Collections.swap(nums, i, index);
            //continue to next indices only if permutation is beatiful
            if(nums.get(index) % (index+1) == 0 || (index+1) % nums.get(index) == 0)
                countBeatifulPerms(nums,index+1);
            
            // else backtrack to previous state
            Collections.swap(nums, i, index);
        }
    }
    
}