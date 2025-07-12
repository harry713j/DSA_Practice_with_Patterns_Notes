package binarytree.leetcode.easy;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {
    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // brute-force: calculate the left height and right height at each node and add them take the maximum
        findMaxDiameter(root);

        return maxDiameter;
        // time: O(n^2)
        // space: O(n)
    }

    private void findMaxDiameter(TreeNode root){
        if (root == null){
            return;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        maxDiameter = Math.max(leftHeight + rightHeight, maxDiameter);

        findMaxDiameter(root.left);
        findMaxDiameter(root.right);
    }

    private int height(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTreeTwo(TreeNode root) {
        // optimal: calculate during height calculation
        int[] diameter = new int[1]; // we are gonna pass array as parameter because
        // if we pass primitive type then it will only change the local copy
        findHeight(root, diameter);
        return diameter[0];
        // time: O(n)
        // space: O(n) // recursion
    }

    private int findHeight(TreeNode root, int[] maxD){
        if (root == null){
            return 0;
        }

        int leftHeight = findHeight(root.left, maxD);
        int rightHeight = findHeight(root.right, maxD);

        maxD[0] = Math.max(maxD[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static class TreeNode {
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
