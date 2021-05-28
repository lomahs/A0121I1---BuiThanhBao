package deployment.usingarray.queue;

public class MainTest {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(4);

        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(6);
        queue.dequeue();
        queue.enqueue(7);
        queue.showQueue();
    }
}
