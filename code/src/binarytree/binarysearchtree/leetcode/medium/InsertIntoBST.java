package binarytree.binarysearchtree.leetcode.medium;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        root = insertRecursive(root, val);
        return root;
        // time: O(log n)
        // space: O(log n)
    }

    private TreeNode insertRecursive(TreeNode root, int val) {
        if (root == null){
            root = new TreeNode(val);
            return root;
        }

        if (root.val > val){
            root.left = insertRecursive(root.left, val);
        } else {
            root.right = insertRecursive(root.right, val);
        }

        return root;
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
