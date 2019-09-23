/*
Author: Akhilesh Borgaonkar
Problem: You need to find the largest value in each row of a binary tree.
Approach: Using BFS to perform level order traversal and then finding the largest in the resultant lists.
Time Complexity: O(n) to get values in row and O(log n) to get max from rows.
Space complexity: O(n) to store output values.
*/

import java.util.ArrayList;
import java.util.List;

public class LargestInRow {

    static class TreeNode{

        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { value = x; }
    }

    private static void getValuesInRow(TreeNode root, int level, List<List<Integer>> output){   //get level order nodes

        if(root==null)
            return;
        if(level==output.size())
            output.add(new ArrayList<Integer>());

        output.get(level).add(root.value);
        getValuesInRow(root.left, level+1, output);
        getValuesInRow(root.right, level+1, output);
    }

    private static void getMaxFromRows(List<List<Integer>> output){ //find the largest in rows
        int i = 0;
        int[] max = new int[output.size()];
        for(List<Integer> out : output){
            for(int node : out){
                if(max[i] < node)
                    max[i] = node;
            }
            i++;
        }

        System.out.println("The largest values from the rows are: " + max[0] + "," + max[1] + "," + max[2]);
    }

    public static void main(String[] args) {

        TreeNode inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(3);
        inputTree.right = new TreeNode(2);
        inputTree.left.left = new TreeNode(5);
        inputTree.left.right = new TreeNode(3);
        inputTree.right.right = new TreeNode(9);    //Sample input set

        int level = 0;
        List<List<Integer>> output = new ArrayList<>();

        getValuesInRow(inputTree, level, output);
        getMaxFromRows(output);
    }
}
