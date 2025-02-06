// Time Complexity : O(N^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(N^2), SC = O(1)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; ++i) {
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j <= i; ++j) {
                if(j == 0 || j == i) l.add(1);
                else l.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            res.add(l);
        }
        return res;
    }
}