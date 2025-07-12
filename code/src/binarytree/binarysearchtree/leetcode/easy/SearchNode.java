package binarytree.binarysearchtree.leetcode.easy;

// https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchNode {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val > val){
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
        // time: O(log n / h), height of the BST
        // space: O(log n / h)
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
