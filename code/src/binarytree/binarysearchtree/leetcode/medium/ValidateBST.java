package binarytree.binarysearchtree.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBST {
    public boolean isValidBST_BF(TreeNode root) {
        // brute-force:
        if (root == null) return true;
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);

        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(i) <= nodes.get(i - 1)){
                return false;
            }
        }

        return true;
        // time: O(n)
        // space: O(n)
    }

    private void inorder(TreeNode root, List<Integer> nodes) {
        if (root == null){
            return;
        }

        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }

    public boolean isValidBST(TreeNode root) {
        // optimal

        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        // time: O(n)
        // space: O(1)
    }

    private boolean helper(TreeNode root, long minRange, long maxRange) {
        if (root == null){
            return true;
        }

        boolean leftCheck = helper(root.left, minRange, root.val);
        boolean rightCheck = helper(root.right, root.val, maxRange);

        boolean currCheck = minRange < root.val && root.val < maxRange;

        return leftCheck && currCheck && rightCheck;
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
