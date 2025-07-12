package binarytree.impl;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T>{
    private Node<T> root;

    public BinaryTree(){
        this.root = null;
    }

    public void insert(T data){
        if (data == null){
            throw new IllegalArgumentException("Value can't be null");
        }

        Node<T> newNode = new Node<>(data);

        // if the root is null
        if (root == null){
            root = newNode;
            return;
        }
        // if root is not null
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node<T> temp = queue.poll();

            // if left child is null
            if (temp.left == null){
                temp.left = newNode;
                return;
            } else {
                queue.add(temp.left);
            }

            // if right child is null
            if (temp.right == null){
                temp.right = newNode;
                return;
            } else {
                queue.add(temp.right);
            }

        }

        // time: O(n)
    }

    public void preorder(){
        // print the tree
        preorderRecursive(root);
        System.out.println();
    }

    private void preorderRecursive(Node<T> node){
        if (node == null){
            return;
        }

        System.out.print(node.data + " ");
        preorderRecursive(node.left);
        preorderRecursive(node.right);
    }

    public void inorder(){
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node<T> node){
        if (node == null){
            return;
        }

        inorderRecursive(node.left);
        System.out.print(node.data + " ");
        inorderRecursive(node.right);
    }

    public void postorder(){
        postorderRecursive(root);
        System.out.println();
    }

    private void postorderRecursive(Node<T> node){
        if (node == null){
            return;
        }

        postorderRecursive(node.left);
        postorderRecursive(node.right);
        System.out.print(node.data + " ");
    }

    public boolean search(T key){
        if (key == null || root == null){
            return false;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node<T> current = queue.poll();

            if (current.data == key){
                return true;
            }

            if (current.left != null){
                queue.add(current.left);
            }

            if (current.right != null){
                queue.add(current.right);
            }
        }

        return false;
    }

    private static class Node<T>{
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T value){
            this.data = value;
            left = right = null;
        }

    }
}
