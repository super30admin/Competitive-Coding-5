import java.util.ArrayList;
import java.util.List;


//Using DFS APPRAOCH
//Time and space complexity is 0(N)
public class FindLargestInEachRow {
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        //using dfs approach
        if(root==null) return result;
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int level){
        if(root==null) return;
        int size = result.size();
        if(level==size){
            result.add(root.val);
        }
        else{
            int temp = result.get(level);
            if(root.val>temp){
                result.set(level,root.val);
            }
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}