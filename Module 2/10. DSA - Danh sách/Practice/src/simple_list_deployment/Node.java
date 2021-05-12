package simple_list_deployment;

public class Node {
    private final Object data;
    private Node next;

    public Node(Object data){
        this.data = data;
    }

    public Node getNext(){
        return next;
    }

    public Object getData(){
        return data;
    }
}
