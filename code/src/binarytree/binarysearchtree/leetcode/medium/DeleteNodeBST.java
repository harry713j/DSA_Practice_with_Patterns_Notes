package binarytree.binarysearchtree.leetcode.medium;

// https://leetcode.com/problems/delete-node-in-a-bst/
public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        root = deleteNodeRec(root, key);
        return root;
        // time: O(log n)
        // space: O(log n)
    }

    private TreeNode deleteNodeRec(TreeNode root, int key) {
        if (root == null){
            return null;
        }

        if (key < root.val){
            root.left = deleteNodeRec(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNodeRec(root.right, key);
        } else {
            // found the node
            if (root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // both are not null, then find a node to replace the node that we want to delete
            root.val = minvalueNode(root.right);
            // now delete that node
            root.right = deleteNodeRec(root.right, root.val);
        }

        return root;
    }

    private int minvalueNode(TreeNode root) {
        int minValue = root.val;

        while (root.left != null){
            minValue = root.left.val;
            root = root.left;
        }

        return minValue;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
