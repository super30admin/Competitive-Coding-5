//Time Complexity: O(n)
//Space Complexity: O(n)
import java.util.ArrayList;
import java.util.List;

public class GreatestValueInEachRow {
    List<Integer> list = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        helper(root, 0);
        return list;
    }

    public void helper(TreeNode root, int level){
        if(root==null){
            return;
        }
        if(list.size()==level){
            list.add(root.val);
        }
        else{
            int maxVal = Math.max(list.get(level), root.val);
            list.set(level, maxVal);
        }

        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}
