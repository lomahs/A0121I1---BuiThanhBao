package deployment.usingarray.stack;

public class MyStack {
    public int[] arr;
    public int size;
    public int index;

    public MyStack(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void push(int element){
        if (isFull()){
            throw new StackOverflowError("Stack is full");
        }
        arr[index] = element;
        index++;
    }

    public int pop(){
        if (isEmpty()){
            throw new NullPointerException("Stack is null");
        }
        return arr[--index];
    }

    public int size(){
        return index;
    }

    public boolean isEmpty(){
        return index == 0;
    }

    public boolean isFull(){
        return index == size;
    }

    public void showStack(){
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
