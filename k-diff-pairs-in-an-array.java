// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findPairs(int[] nums, int k) {
        // TC = O(N), SC = O(N)
        // null
        if(nums == null || nums.length < 2 || k < 0) return 0;
        // storing index too to take care of duplicates
        HashMap<Integer, Integer>m = new HashMap<>();
        HashSet<List<Integer>> res = new HashSet<>(); // using hashset to avoid duplicates
        for(int i = 0; i < nums.length; i++) m.put(nums[i], i);
        for(int i = 0; i < nums.length; i++) {
            int complement = nums[i] + k; // checking for either of k-diff pair exists
            if(m.containsKey(complement)){
                // checking if index is not the same. Eg 3 pair(1, 1)
                if(m.get(complement) != i) {
                    List<Integer> l = Arrays.asList(nums[i], complement);
                    Collections.sort(l); // sorting to store unique elements in hashset
                    res.add(l);
                }
            } 
        }
        return res.size();
    }
}