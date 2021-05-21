package library.deployment.linkedlist;

import java.util.LinkedList;

public class MyLinkedList<E> {
    private Node head = null;
    private int numNodes;

    public MyLinkedList() {
    }

    public void add(int index, E element) {
        if (index == 0) {
            addFirst(element);
        } else if (index >= numNodes) {
            addLast(element);
        } else {
            Node temp = head;
            int count = 0;

            while (temp.next != null && count < index - 1) {
                temp = temp.next;
                count++;
            }

            Node holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;

            numNodes++;
        }
    }

    public void addFirst(E e) {
        if (head == null) {
            head = new Node(e);
        } else {
            Node p = new Node(e);
            p.next = head;
            head = p;
        }
        numNodes++;
    }

    public void addLast(E e) {
        if (head == null) {
            addFirst(e);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new Node(e);
            numNodes++;
        }

    }

    public void remove(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        numNodes--;
    }

    public boolean remove(E e) {
        if (contains(e)) {
            remove(indexOf(e));
            return true;
        }

        return false;
    }

    public int size() {
        return numNodes;
    }

    @SuppressWarnings("unchecked")
    public Object clone() {
        MyLinkedList<E> clone = new MyLinkedList<>();

        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            clone.addLast((E) temp.getData());
        }

        return clone;
    }

    public boolean contains(E o) {
        Node temp = head;

        while (temp.next != null) {
            if (temp.getData() == o)
                return true;
            temp = temp.next;
        }

        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData() == o)
                return i;
            temp = temp.next;
        }

        return -1;
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i >= numNodes)
            throw new IndexOutOfBoundsException();
        else if (i == 0) {
            return getFirst();
        } else if (i == numNodes - 1) {
            return getLast();
        } else {
            Node temp = head;
            for (int j = 0; j < i; j++) {
                temp = temp.next;
            }
            return (E) temp.getData();
        }
    }

    @SuppressWarnings("unchecked")
    public E getFirst() {
        return (E) head.getData();
    }

    @SuppressWarnings("unchecked")
    public E getLast() {
        Node temp = head;
        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
        }

        return (E) temp.getData();
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    public String toString() {
        StringBuilder str = new StringBuilder("List (size: " + numNodes + "){");
        Node temp = head;
        for (int i = 0; i < numNodes-1; i++) {
            str.append(temp.getData()).append(", ");
            temp = temp.next;
        }


        str.append(temp.getData()).append("}");
        return String.valueOf(str);

    }
}
