package binarytree.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {
    public List<Integer> boundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (!isLeaf(root)) ans.add(root.data);
        addLeftBoundary(root.left, ans);
        addLeaves(root, ans);
        addRightBoundary(root.right, ans);
        return ans;
    }

    private void addRightBoundary(TreeNode root, List<Integer> ans) {
        Stack<Integer> stack = new Stack<>();
        while (root != null){
            if (!isLeaf(root)) stack.push(root.data);

            if (root.right != null){
                root = root.right;
            } else {
                root = root.left;
            }
        }

        // retrieve
        while (!stack.isEmpty()){
            ans.add(stack.pop());
        }
    }

    private void addLeaves(TreeNode root, List<Integer> ans) {
        if (isLeaf(root)){
            ans.add(root.data);
            return;
        }

        if (root.left != null) addLeaves(root.left, ans);
        if (root.right != null) addLeaves(root.right, ans);
    }

    private void addLeftBoundary(TreeNode root, List<Integer> ans) {
        while (root != null){
            if (!isLeaf(root)) ans.add(root.data);

            if (root.left != null){
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
  }
}
