// TC = O(valid permutations)
// SC = O(visited nodes)
class Solution {
    int count = 0;
    private void backtrack(int n, int pos, boolean[] visited){
        if(pos>n) count++;
        for(int i=1; i<=n; i++){
            //action
            if(!visited[i] && (i%pos == 0 || pos%i == 0)){
                visited[i] = true;
                //recure
                backtrack(n,pos+1,visited);
                //backtrack
                visited[i] = false;
            }
        }
    }
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        backtrack(n, 1, visited);
        return count;
}
}