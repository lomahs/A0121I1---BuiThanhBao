package bst_traversal;

import bst_traversal.binarysearchtree.BinarySearchTree;
import com.sun.source.tree.Tree;

/**
 * Project: Exercise
 * Package: bst_traversal
 * User: lomahs
 * Date time: 31/05/2021 18:06
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree bstTree = new BinarySearchTree();

        bstTree.add(10);

        bstTree.add(6);
        bstTree.add(8);
        bstTree.add(12);
        bstTree.add(4);
        bstTree.add(17);
        bstTree.add(7);
        bstTree.add(9);


        bstTree.traversePostOrder(bstTree.root);
        System.out.println();
        bstTree.path(bstTree.root, 7);

    }
}
