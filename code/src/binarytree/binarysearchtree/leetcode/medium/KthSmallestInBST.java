package binarytree.binarysearchtree.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        // brute-force: traverse the nodes and store it in a list and find the kth smallest
        if (root == null){
            return -1;
        }
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);

        if (nodes.size() < k){
            return -1;
        }

        return nodes.get(k - 1);
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

    public int kthSmallestTwo(TreeNode root, int k) {
        // optimal
        int[] count = new int[1];
        int[] ans = new int[1];
        ans[0] = -1;
        helper(root, k, count, ans);
        return ans[0];
        // time: O(n)
        // space: O(n), only recursion stack
    }

    private void helper(TreeNode root, int k, int[] count, int[] ans) {
        if (root == null){
            return;
        }

        helper(root.left, k, count, ans);
        count[0]++;
        if (count[0] == k){
            ans[0] = root.val;
            return;
        }
        helper(root.right, k, count, ans);
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
