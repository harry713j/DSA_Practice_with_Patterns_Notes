package binarytree.leetcode.hard;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // : as we calculate the diameter while calculating the height we will add up the node value
        findPathSum(root);

        return maxSum;
        // time: O(n)
        // space: O(n)
    }

    private int findPathSum(TreeNode root) {
        // like calculating the tree height
        if (root == null){
            return 0;
        }
        // we will ignore the negative value
        int leftSum = Math.max(0, findPathSum(root.left));
        int rightSum = Math.max(0, findPathSum(root.right));

        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
