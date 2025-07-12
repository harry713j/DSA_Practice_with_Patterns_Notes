package binarytree.leetcode.easy;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftSideDepth = maxDepth(root.left);
        int rightSideDepth = maxDepth(root.right);

        return 1 + Math.max(leftSideDepth, rightSideDepth);
        // time : O(n)
        // space: O(h) height of the binary tree (log n)
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
