
import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

class LargestValueInRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> mq = new LinkedList<>();
        Queue<TreeNode> tq = new LinkedList<>();
        mq.add(root);
        result.add(root.data);
        while(!mq.isEmpty()){
            TreeNode curr = mq.poll();

            if(curr.left != null) tq.add(curr.left);
            if(curr.right != null) tq.add(curr.right);
            
            if(mq.isEmpty() && !tq.isEmpty()){
                int maxValue = Integer.MIN_VALUE;
                while(!tq.isEmpty()){
                    TreeNode levelEle = tq.poll();
                    if(levelEle.data > maxValue){
                        maxValue = levelEle.data;
                    }
                    mq.add(levelEle);

                }
                result.add(maxValue);
            }
        }
        return result;
    }

    public void bfs(TreeNode root, List<Integer> result){
        Queue<TreeNode> mq = new LinkedList<>();
        Queue<TreeNode> tq = new LinkedList<>();
        mq.add(root);
        result.add(root.data);
        while(!mq.isEmpty()){
            TreeNode curr = mq.poll();

            if(curr.left != null) tq.add(curr.left);
            if(curr.right != null) tq.add(curr.right);
            
            if(mq.isEmpty() && !tq.isEmpty()){
                int maxValue = Integer.MIN_VALUE;
                while(!tq.isEmpty()){
                    TreeNode levelEle = tq.poll();
                    if(levelEle.data > maxValue){
                        maxValue = levelEle.data;
                    }
                    mq.add(levelEle);

                }
                result.add(maxValue);
            }
        }
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("LargestValueInRow");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        LargestValueInRow obj = new LargestValueInRow();
        System.out.println(obj.largestValues(root));
    }
}