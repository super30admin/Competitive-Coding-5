public class BeautifulArrangement {
    int count = 0;
    public int countArrangement(int n) {
        boolean visited[] = new boolean[n+1];
        backtrack(1, visited, n);
        return count;
    }

    public void backtrack(int pos, boolean visited[], int n){
        //base 
        if(pos > n){
            count++;
            return;
        }
        //logic 
        for(int i = 1; i <= n; i++){
            if(!visited[i] && (pos % i == 0 || i % pos == 0)){
                visited[i] = true;
                backtrack(pos+1, visited, n);
                visited[i] = false;
            }
        }

    }
}
