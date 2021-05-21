package deployment_queue_with_circularlinkedlist;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(4);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(6);
        queue.enqueue(7);

        System.out.print("Queue: ");
        queue.displayQueue();

        System.out.println("Dequeue: " + queue.dequeue());

        System.out.print("Queue after dequeue: ");
        queue.displayQueue();


    }
}
