package deployment.usingarray.queue;

public class MyQueue {
    public int capacity;
    public int[] queueArr;
    public int head;
    public int tail=-1;
    public int currentSize;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[queueSize];
    }

    public boolean isQueueFull(){
        return currentSize == capacity;
    }

    public boolean isQueueEmpty(){
        return currentSize == 0;
    }

    public void enqueue(int item){
        if (isQueueFull()){
            System.out.println("Overflow! Unable to add: " + item);
        }else {
            tail++;
            if (tail== capacity){
                tail=0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element: " + item + " is pushed to Queue");
        }
    }

    public void dequeue(){
        if (isQueueEmpty()){
            System.out.println("Underflow! Unable to remove element.");
        }else {
            int removed = queueArr[head];
            queueArr[head] = 0;
            head++;
            if (head == capacity-1){
                head = 0;
            }
            currentSize--;
            System.out.println("Pop operation done! Removed: " + removed);
        }
    }

    public void showQueue(){
        int run = (tail >head)?tail:capacity;
        for (int i = head; i < run; i++) {
            System.out.print(queueArr[i] + " ");
        }
        for (int i = 0; i <= tail; i++) {
            System.out.println(queueArr[i] + " ");
        }
    }
}
