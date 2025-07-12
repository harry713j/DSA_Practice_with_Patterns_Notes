package binarytree.leetcode.easy;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        // brute-force
        if (root == null) return true;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1) return false;

        // calculate for subtree
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        return left && right;
        // time : O(n)
        // space: O(h)
    }

    private int depth(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        return 1 + Math.max(left, right);
    }

    public boolean isBalancedTwo(TreeNode root) {
        return dfsHeight(root) != -1;
        // time: O(n)
        // space: O(h)
    }

    private int dfsHeight(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
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
