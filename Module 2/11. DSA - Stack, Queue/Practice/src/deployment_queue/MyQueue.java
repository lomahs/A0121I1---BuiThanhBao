package deployment_queue;

public class MyQueue {
    public Node head;
    public Node tail;

    public MyQueue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int key){
        Node temp = new Node(key);
        if (this.tail == null) {
            this.head = this.tail = temp;
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
    }

    public Node dequeue(){
        if (head == null){
            return null;
        }
        Node temp = head;
        head = head.next;

        if (head == null){
            tail = null;
        }

        return temp;
    }
}
