package binarytree.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
// https://leetcode.com/problems/binary-tree-postorder-traversal/description/
public class Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        preorderHelper(root, ans);

        return ans;
        // time: O(n)
        // space: O(1)
    }

    private void preorderHelper(TreeNode root, List<Integer> ans) {
        if (root == null){
            return;
        }

        ans.add(root.val);
        preorderHelper(root.left, ans);
        preorderHelper(root.right, ans);
    }

    public List<Integer> iterativePreorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        stack.push(root);

        while (!stack.empty()){
            TreeNode temp = stack.pop();
            ans.add(temp.val);

            if (temp.right != null){
                stack.push(temp.right);
            }

            if (temp.left != null){
                stack.push(temp.left);
            }
        }

        return ans;
        // time: O(n)
        // space: O(n)
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        inorderHelper(root, ans);

        return ans;
        // time: O(n)
        // space: O(1)
    }

    private void inorderHelper(TreeNode root, List<Integer> ans) {
        if (root == null){
            return;
        }

        inorderHelper(root.left, ans);
        ans.add(root.val);
        inorderHelper(root.right, ans);
    }

    public List<Integer> iterativeInorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode node = root;

        while (true){
            if (node != null){
                stack.push(node);
                node = node.left;
            } else {
                if (stack.empty()){
                    break;
                }
                node = stack.pop();
                ans.add(node.val);
                node = node.right;
            }
        }

        return ans;
        // time: O(n)
        // space: O(1)
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        postorderHelper(root, ans);

        return ans;
        // time: O(n)
        // space: O(1)
    }

    private void postorderHelper(TreeNode root, List<Integer> ans) {
        if (root == null){
            return;
        }

        postorderHelper(root.left, ans);
        postorderHelper(root.right, ans);
        ans.add(root.val);
    }

    public List<Integer> iterativePostorderTraversal(TreeNode root) {
        // using two stack
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;
        st1.push(root);

        while (!st1.empty()){
            root = st1.pop();
            st2.push(root);

            if (root.left != null) st1.push(root.left);
            if (root.right != null) st1.push(root.right);
        }

        while (!st2.empty()){
            ans.add(st2.pop().val);
        }

        return ans;
        // time: O(n)
        // space: O(n)
    }

    public List<Integer> iterativePostorderTraversalTwo(TreeNode root) {
        // using one stack
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;
        TreeNode curr = root;

        while (curr != null || !stack.empty()){
            if (curr != null){
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.peek().right;

                if (temp == null){
                    temp = stack.pop();
                    ans.add(temp.val);

                    while (!stack.empty() && temp == stack.peek().right){
                        temp = stack.pop();
                        ans.add(temp.val);
                    }
                } else {
                    curr = temp;
                }
            }
        }

        return ans;
        // time: O(n)
        // space: O(n)
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
