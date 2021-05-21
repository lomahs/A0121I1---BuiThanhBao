package simple_linkedlist_deployment;

public class MyLinkedList {
    private Node head;
    private int numNodes;

    public MyLinkedList(Object data){
        head = new Node(data);
    }

    public void add(int index, Object data){
        Node temp = head;

        for (int i = 0; i < index-1 && temp.getNext() !=null; i++) {
            temp = temp.getNext();
        }

        Node holder = temp.getNext();
        Node newNode = new Node(data);
        temp.setNext(newNode);
        newNode.setNext(holder);
        numNodes++;
    }

    public void addFirst(Object data){
        Node temp = head;
        Node newNode = new Node(data);
        newNode.setNext(temp);
        head = newNode;
    }

    public Node get(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    public void printList(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.getData()+ "  ");
            temp  = temp.getNext();
        }
    }
}
