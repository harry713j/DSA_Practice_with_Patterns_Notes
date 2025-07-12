package binarytree.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return ans;

        queue.offer(root);

        while (!queue.isEmpty()){
            int numLevel = queue.size();
            List<Integer> subList = new LinkedList<>();

            for (int i = 0; i < numLevel; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }

                if (queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }

                subList.add(queue.poll().val);
            }

            ans.add(subList);
        }

        return ans;
        // time: O(n)
        // space: O(n)
    }

    public List<List<Integer>> levelOrderTwo(TreeNode root) {
        if(root == null) {
            return  new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 0,result);
        return result;
    }

    public void traverse(TreeNode root, int level, List<List<Integer>> result) {
        if(result.size() <= level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);
        if(root.left != null) {
            traverse(root.left, level + 1, result);
        }
        if(root.right != null) {
            traverse(root.right, level + 1, result);
        }

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
