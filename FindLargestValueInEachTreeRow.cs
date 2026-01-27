// Time Complexity - O(N)
// Space Complexity - O(H)

// Approach
// Maintain one global list which stores single value per level.
//Used DFS , added root in the list, jumped to the next level, check if list count and level count is same then add element in the queue.
// if the level count and list count doesnt match then check value in the list of that level and current val whichever is max add it at the level index.
public class Solution
{
    public IList<int> LargestValues(TreeNode root)
    {
        List<int> result = new List<int>();
        DFS(root, 0, result);
        return result;
    }

    private void DFS(TreeNode node, int level, List<int> result)
    {
        if (node == null)
            return;

        // first time reaching this level
        if (level == result.Count)
        {
            result.Add(node.val);
        }
        else
        {
            result[level] = Math.Max(result[level], node.val);
        }

        DFS(node.left, level + 1, result);
        DFS(node.right, level + 1, result);
    }
}
