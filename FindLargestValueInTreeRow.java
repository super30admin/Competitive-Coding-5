//Time Complexity=O(n)
//Space Complexity=O(n)
public class FindLargestValueInTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;

        Queue<TreeNode> q=new LinkedList();
        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            int max=Integer.MIN_VALUE;

            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                max=Math.max(max,curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            list.add(max);
        }

        return list;
    }
}
