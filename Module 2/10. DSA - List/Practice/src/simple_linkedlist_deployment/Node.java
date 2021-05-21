package simple_linkedlist_deployment;

public class Node {
    private final Object data;
    private Node next;

    public Node(Object data){
        this.data = data;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Object getData(){
        return data;
    }
}
