class ArrayQueue {
    private int[] queue;
    private int front, rear, size, capacity;
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = size = 0;
    }
    public void enqueue(int data) {
        if (size == capacity) {
            System.out.println("Queue Overflow");
            return;
        }
        queue[rear] = data;
        rear = (rear + 1) % capacity;
        size++;
    }
    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow");
            return;
        }
        int removed = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Dequeued: " + removed);
    }
    public void display() {
        if (size == 0) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Queue (Array): ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}
public class DAA_A4_QueueArray {
    public static void main(String[] args) {
        System.out.println("Using Array Queue:");
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.display();
        arrayQueue.dequeue();
        arrayQueue.display();
    }
}
