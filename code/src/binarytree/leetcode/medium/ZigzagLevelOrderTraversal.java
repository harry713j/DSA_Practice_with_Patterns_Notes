package binarytree.leetcode.medium;

import java.util.*;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // level order traversal with a queue
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean rightToleft = false; // false means left to right and true means right to left
        queue.offer(root);

        while (!queue.isEmpty()){
            int level = queue.size();
            List<Integer> sublist = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);

                sublist.add(queue.poll().val);
            }

            // check traversal direction
            if (rightToleft){
                Collections.reverse(sublist);
            }

            rightToleft = !rightToleft;
            ans.add(sublist);
        }

        return ans;
        // time: O(n)
        // space: O(n)
    }

    public List<List<Integer>> zigzagLevelOrderTwo(TreeNode root) {
        // level order traversal with a queue
        // little optimized,
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean rightToleft = false; // false means left to right and true means right to left
        queue.offer(root);

        while (!queue.isEmpty()){
            int level = queue.size();
            List<Integer> sublist = new LinkedList<>();

            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();

                if (rightToleft){
                    sublist.addFirst(node.val);
                } else {
                    sublist.addLast(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            rightToleft = !rightToleft;
            ans.add(sublist);
        }

        return ans;
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
