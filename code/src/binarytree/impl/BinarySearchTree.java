package binarytree.impl;

public class BinarySearchTree<T extends Number> {
    private Node<T> root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(T data){
        if (data == null){
            throw new IllegalArgumentException("Node value can't be null");
        }
//        Node<T> newNode = new Node<>(data);
//        // root is null
//        if (root == null){
//            root = newNode;
//            return;
//        }
//
//        Node<T> temp = root;
//        Node<T> prev = null;
//
//        while (temp != null){
//            prev = temp;
//            // we will use Integer for test
//            if (temp.data.intValue() > data.intValue()){
//                temp = temp.left;
//            } else if (temp.data.intValue() < data.intValue()) {
//                temp = temp.right;
//            }
//        }
//
//        if (prev.data.intValue() > data.intValue())
//            prev.left = newNode;
//        else
//            prev.right = newNode;

        root = insertRecursive(root, data);
    }

    private Node<T> insertRecursive(Node<T> node, T key){
        if (node == null){
            node = new Node<>(key);
            return node;
        }

        if (node.data.intValue() > key.intValue())
            node.left = insertRecursive(node.left, key);
        else if (node.data.intValue() < key.intValue())
            node.right = insertRecursive(node.right, key);

        return node;
    }

    public boolean search(T key){
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(Node<T> node, T key) {
        if (node == null){
            return false;
        }

        if (key.intValue() == node.data.intValue()){
            return true;
        } else if (key.intValue() < node.data.intValue()) {
            return searchRecursive(node.left, key);
        } else {
            return searchRecursive(node.right, key);
        }
    }

    public void delete(T key){
        root = deleteRecursive(root, key);
    }

    private Node<T> deleteRecursive(Node<T> node, T key){
        if (node == null){
            return null;
        }

        // search the node
        if (key.intValue() < node.data.intValue()){
            node.left = deleteRecursive(node.left, key);
        } else if (key.intValue() > node.data.intValue()) {
            node.right = deleteRecursive(node.right, key);
        } else {
            // we got the node to delete
            // if the node have only one child or no child
            if (node.left == null){
                return node.right;
            } else if (node.right == null){
                return node.left;
            }

            // if node has two children, then we can replace the value of node to be deleted with its inorder predecessor
            // or inorder successor, here i am taking inorder predecessor
            node.data = inorderPredecessor(node.left);

            // now delete the inorder predecessor
            node.left = deleteRecursive(node.left, node.data);
        }

        return node;
    }

    private T inorderPredecessor(Node<T> node) {
        T maxValue = node.data;

        while (node.right != null){
            maxValue = node.right.data;
            node = node.right;
        }

        return maxValue;
    }

    // inorder print the tree in sorted order
    public void inorder(){
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node<T> node) {
        if (node == null){
            return;
        }
        inorderRecursive(node.left);
        System.out.print(node.data + " ");
        inorderRecursive(node.right);
    }

    public int height(){
        return heightRecursive(root);
    }

    private int heightRecursive(Node<T> node) {
        if (node == null){
            return -1;
        }

        int leftHeight = heightRecursive(node.left);
        int rightHeight = heightRecursive(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static class Node<T extends Number> {
        private T data;
        private Node<T> left, right;

        public Node(T value){
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }
}
