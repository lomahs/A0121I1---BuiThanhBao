package bst_traversal.binarysearchtree;

/**
 * Project: Exercise
 * Package: bst_traversal.binarysearchtree
 * User: lomahs
 * Date time: 31/05/2021 18:24
 * Created with IntelliJ IDEA
 */
public class BinarySearchTree {
    public Node root;

    public Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }else {
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (current.value == value) {
            return true;
        }

        return (value < current.value) ?
                containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value){
        return containsNodeRecursive(root, value);
    }

    public Node removeRecursive(Node current, int value){
        if (current == null){
            return null;
        }

        if (value == current.value){

            //No children
            if (current.left == null && current.right == null){
                return null;
            }

            //One child
            if (current.left == null || current.right == null){
                return  (current.left == null)?current.right:current.left;
            }

            //Two children
            int smallest = findSmallestValue(current.right);
            current.value = smallest;
            current.right = removeRecursive(current.right, smallest);
            return current;
        }

        if (value< current.value){
            current.left = removeRecursive(current.left,value);
            return current;
        }

        current.right = removeRecursive(current.right,value);
        return current;
    }

    public void delete(int value){
        root = removeRecursive(root,value);
    }

    public int findSmallestValue(Node current){
        return current.left == null ? current.value : findSmallestValue(current.left);
    }

    public void traversePostOrder(Node current){
        if (current != null){
            traversePostOrder(current.left);
            traversePostOrder(current.right);
            System.out.print(current.value + " ");
        }
    }

    public void traversePreOrder(Node current){
        if (current!=null){
            System.out.print(current.value + " ");
            traversePreOrder(current.left);
            traversePreOrder(current.right);
        }
    }

    public void traverseInOrder(Node current){
        if (current!=null){
            traverseInOrder(current.left);
            System.out.print(current.value + " ");
            traverseInOrder(current.right);
        }
    }

    public void path(Node current, int value){
        if (current != null){
            if (current.value == value){
                System.out.print(value + " ");
            }

            if (value < current.value){
                System.out.print(current.value + " ");
                path(current.left,value);
            }

            if (value>current.value){
                System.out.print(current.value + " ");
                path(current.right,value);
            }
        }
    }
}
