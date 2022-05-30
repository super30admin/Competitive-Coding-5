using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class LargestValueInEachTreeRow
    {
        /// Time Complexity : O(N) 
        // Space Complexity :O(N) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No 
        public IList<int> LargestValues(TreeNode root)
        {
            List<int> result = new List<int>();
            if (root == null) return result;

            Queue<TreeNode> q = new Queue<TreeNode>();
            q.Enqueue(root);

            while (q.Count != 0)
            {

                int size = q.Count;
                int max = int.MinValue;
                for (int i = 0; i < size; i++)
                {
                    TreeNode curr = q.Dequeue();
                    max = Math.Max(max, curr.val);
                    if (curr.left != null) q.Enqueue(curr.left);
                    if (curr.right != null) q.Enqueue(curr.right);
                }
                result.Add(max);
            }

            return result;

        }
    }
}
