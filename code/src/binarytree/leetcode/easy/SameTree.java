package binarytree.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SameTree {
    public boolean isSameTreeTwo(TreeNode p, TreeNode q) {
        // brute-force: retrieve the tree and put the value inside a list and compare two lists
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        preorder(p, l1);
        preorder(q, l2);

        // different size
        if (l1.size() != l2.size()){
            return false;
        }

        for (int i = 0; i < l1.size(); i++) {
            if (!Objects.equals(l1.get(i), l2.get(i))){
                return false;
            }
        }

        return true;
        // time: O(n)
        // space: O(n)
    }

    private void preorder(TreeNode root, List<Integer> list){
        if (root == null){
            list.add(null);
            return;
        }

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // optimal:
        if (p == null && q == null){
            return true;
        }
        // if both tree are different at a point
        if (p == null || q == null || p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        // time: O(n)
        // space: O(n)
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
