// Time Complexity :O(n!) in the worst case (trying all permutations). But it's less than n! due to the pruning from the divisibility condition.
//Space Complexity : O(n) for the visited[] array and recursive call stack.

//Use backtracking to try placing numbers 1 to n at each position pos.
//Only place number num at position pos if num % pos == 0 or pos % num == 0.
//Mark the number as visited and recurse to the next position; backtrack after the recursive call.

class Solution {
    int count;
    public int countArrangement(int n) {
        if(n==0)
        {
            return 0;
        }
        int count = 0;
        boolean[] visited = new boolean[n+1];
        backtrack(1, n, visited);
        return count;
    }

    private void backtrack(int pos, int n, boolean[] visited)
    {
        //base
        if(pos > n)
        {
            
            count++;
            return;
        }
        //logic
        for(int nums = 1; nums<= n; nums++)
        {
            if((!visited[nums]) && (nums % pos == 0 || pos % nums == 0))
            {
                visited[nums] = true;
                backtrack(pos+1, n, visited);
                visited[nums] = false;
            }
        }
    }
}