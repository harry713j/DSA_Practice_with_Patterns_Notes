package binarytree.impl;

public class Main {
    public static void main(String[] args) {
//        BinaryTree<Integer> bt = new BinaryTree<>();
//        bt.insert(5);
//        bt.insert(7);
//        bt.insert(9);
//        bt.insert(8);
//        bt.insert(10);
//
//        bt.preorder();
//        bt.inorder();
//        bt.postorder();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(25);

        bst.inorder();
        System.out.println("Height: " + bst.height());

        bst.insert(35);
        bst.insert(45);
        bst.insert(50);

        bst.inorder();
        System.out.println("Height: " + bst.height());

        bst.delete(50);
        bst.delete(40);

        bst.inorder();
        System.out.println("Height: " + bst.height());


    }
}
