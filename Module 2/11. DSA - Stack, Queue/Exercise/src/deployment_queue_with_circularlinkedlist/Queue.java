package deployment_queue_with_circularlinkedlist;

public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (front == null) {
            front = newNode;
        } else {
            rear.link = newNode;
        }
        rear = newNode;
        rear.link = front;
    }

    public int dequeue() {
        if (front == null) {
            throw new NullPointerException("No element left");
        }
        Node temp = front;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.link;
            rear.link = front;
        }
        return temp.data;
    }

    public void displayQueue(){
        if (front == null){
            System.out.println("Queue is empty");
        }else{
            Node temp = front;
            while (temp.link !=front){
                System.out.print(temp.data + " ");
                temp = temp.link;
            }
            System.out.println(temp.data);
        }
    }
}
