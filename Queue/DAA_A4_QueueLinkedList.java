class LinkedListQueue {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    private Node front, rear;
    public LinkedListQueue() {
        front = rear = null;
    }
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    public void dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
            return;
        }
        System.out.println("Dequeued: " + front.data);
        front = front.next;
        if (front == null)
            rear = null;
    }
    public void display() {
        if (front == null) {
            System.out.println("Queue is Empty");
            return;
        }
        Node temp = front;
        System.out.print("Queue (Linked List): ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class DAA_A4_QueueLinkedList {
    public static void main(String[] args) {
        System.out.println("\nUsing Linked List Queue:");
        LinkedListQueue linkedQueue = new LinkedListQueue();
        linkedQueue.enqueue(100);
        linkedQueue.enqueue(200);
        linkedQueue.enqueue(300);
        linkedQueue.display();
        linkedQueue.dequeue();
        linkedQueue.display();
    }
}
