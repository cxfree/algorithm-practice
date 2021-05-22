//Given the root of a binary tree and an integer targetSum, return the number of
// paths where the sum of the values along the path equals targetSum.
//
// The path does not need to start or end at the root or a leaf, but it must go
//downwards (i.e., traveling only from parent nodes to child nodes).
//
//
// Example 1:
//
//
//Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//Output: 3
//Explanation: The paths that sum to 8 are shown.
//
//
// Example 2:
//
//
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: 3
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 1000].
// -109 <= Node.val <= 109
// -1000 <= targetSum <= 1000
//
// Related Topics 树
// 👍 855 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, new HashMap<>(), 0, targetSum);
        return this.ans;
    }

    private int ans = 0;

    private void dfs(TreeNode root, Map<Integer, Integer> preSumToOccurCntMap, int preSum, int target) {
        if (root == null) return;
        int curPreSum = preSum + root.val;
        if (preSumToOccurCntMap.getOrDefault(curPreSum - target, 0) > 0
                || curPreSum == target) {
            ans++;
        }
        preSumToOccurCntMap.put(curPreSum, preSumToOccurCntMap.getOrDefault(curPreSum, 0) + 1);
        dfs(root.left, preSumToOccurCntMap, curPreSum, target);
        dfs(root.right, preSumToOccurCntMap, curPreSum, target);
        preSumToOccurCntMap.put(curPreSum, preSumToOccurCntMap.get(curPreSum) - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
              5
         4         8
     11    x    13   4
   7    2          5    1

 */
