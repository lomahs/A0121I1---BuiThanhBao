package deployment_queue_with_circularlinkedlist;

public class Queue {
    public Node front;
    public Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (front == rear) {
            front = rear = newNode;
        } else {
            rear.link = newNode;
            rear = newNode;
        }
        rear.link = front;
    }

    public int dequeue(){
        return 0;
    }
}
