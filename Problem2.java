/*
    LC - 526. Beautiful Arrangement
    TC - O(n!)
        We are using a backtracking approach to generate all possible arrangements.
        For the first position, we have n choices.
        For the second position, we have n-1 choices.
        This continues until we reach the last position where we have only 1 choice.

        This forms a pattern of n * (n-1) * (n-2) * ... * 2 * 1, which is the definition of n factorial (n!).
    SC - O(n) - recursive space for n recursive calls
    Approach - using backtrack.
*/

class Solution {
    int count;
    boolean[] used;
    public int countArrangement(int n) {
        if(n == 0) {
            return 0;
        }
        count = 0;
        used = new boolean[n + 1];
        backtrack(n, 1);
        return count;
    }
    public void backtrack(int n, int start) {
        // base
        if(start > n) {
            count++;
            return;
        }

        // logic
        for(int i=1; i<=n; i++) {
            if(used[i]) {
                continue;
            }
            if(i % start == 0 || start % i == 0) {
                used[i] = true;
                backtrack(n, start+1);
                used[i] = false;
            }
        }
    }
}