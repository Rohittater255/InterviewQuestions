package codingPart.programs.basicJava.CollectionImp;

import java.util.Vector;

public class StackTest extends Vector {
    //Refer https://www.youtube.com/watch?v=X7asXkoYWCQ&list=PLqq-6Pq4lTTZgXnsBNQwCWdKR6O6Cgk1Z&index=4

    //Variables/Attributes
    int[] arr;
    int capacity;
    int top;

    public StackTest(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.top = -1;
    }


    //Methods/Functions
    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return capacity == top - 1;
    }

    public Object get(int i) {
        return arr[i];
    }


    public void push(int a) {
        if (isFull()) {
            throw new RuntimeException();
        } else {
            arr[++top] = a;
            System.out.println("top" + top);
        }
    }

    public int pop() {
        return arr[top--];
    }

    public int peek() {
        return arr[top];
    }


}
