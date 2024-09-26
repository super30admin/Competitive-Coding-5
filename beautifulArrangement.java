class Solution {
    int count = 0;
    public int countArrangement(int n) {
        if (n == 0 || n == 1) return n;
        
        boolean[] visited = new boolean[n + 1];
        helper(n, 1, visited);
        return count;
    }
    
    private void helper(int n, int pos, boolean[] visited) {
        // base
        if (pos > n)
            count++;
        // logic
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                helper(n, pos+1, visited);
                visited[i] = false;
            }
        }
    }
}

// T.C : O(k), k is number of permutations
// S.C : O(n)