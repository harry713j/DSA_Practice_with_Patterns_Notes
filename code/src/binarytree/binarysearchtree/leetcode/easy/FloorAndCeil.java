package binarytree.binarysearchtree.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FloorAndCeil {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        List<Integer> ans = new ArrayList<>(2);
        ans.add(-1);
        ans.add(-1);
        findFloor(root, key, ans);
        findCeil(root, key, ans);
        return ans;
        // time: O(log n)
        // space: O(log n)
    }

    private void findCeil(TreeNode root, int key, List<Integer> ans) {
        if (root == null){
            return;
        }

        if (root.data < key){
            findCeil(root.right, key, ans);
        } else {
            ans.set(1, root.data);
            findCeil(root.left, key, ans);
        }
    }

    private void findFloor(TreeNode root, int key, List<Integer> ans) {
        if (root == null){
            return;
        }

        if (root.data > key){
            findFloor(root.left, key, ans);
        } else {
            ans.set(0, root.data);
            findFloor(root.right, key, ans);
        }
    }

    public class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { data = val; left = null; right = null; }
  }
}
