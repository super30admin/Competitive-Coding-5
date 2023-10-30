public class BTLargestValueInEachRow
    {
        // Time Complexity : O(n) - have to traverse all nodes
        // Space Complexity : O(n) - queue at most will have n/2 elements in the worst case so amortized will be O(n) 
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public IList<int> LargestValues(TreeNode root)
        {

            IList<int> result = new List<int>();
            if (root == null) return result;
            Queue<TreeNode> q = new Queue<TreeNode>();
            q.Enqueue(root);
            int level = 0;
            while (q.Count > 0)
            {
                int size = q.Count;

                for (int i = 0; i < size; i++)
                {
                    TreeNode curr = q.Dequeue();
                    if (level == result.Count)
                    {
                        result.Add(curr.val);
                    }
                    else
                    {
                        if (curr.val >= result[level])
                        {
                            result[level] = curr.val;
                        }
                    }
                    if (curr.left != null)
                        q.Enqueue(curr.left);
                    if (curr.right != null)
                        q.Enqueue(curr.right);
                }
                level++;
            }
            return result;

        }
    }
