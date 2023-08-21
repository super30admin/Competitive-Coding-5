// Time Complexity : O(n)
// Space Complexity : O(h)  ->h is the max height of the tree
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInTreeRowUsingBFS {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if(root == null) return result;


        Queue<TreeNode> q = new LinkedList<>();
        //int level = 0;

        q.add(root);
        while(!q.isEmpty())
        {
            int max = Integer.MIN_VALUE;
            int size = q.size();

            for(int i=0; i<size; i++)
            {

                TreeNode temp = q.poll();
                max = Math.max(temp.val,max);
                if(i==size-1)
                    result.add(max);
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);


            }
            //  level++;
        }
        return result;
    }
}
