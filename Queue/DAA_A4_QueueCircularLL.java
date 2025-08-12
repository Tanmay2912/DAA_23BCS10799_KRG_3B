public class DAA_A4_QueueCircularLL {
    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }
    private Node front = null; 
    private Node rear = null;  
    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (front == null) {
            front = rear = newNode;
            front.next = front.prev = front;
        } else {
            newNode.prev = rear;
            newNode.next = front;
            rear.next = newNode;
            front.prev = newNode;
            rear = newNode;
        }
        System.out.println(data + " enqueued.");
    }
    public void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println(front.data + " dequeued.");
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = rear;
            rear.next = front;
        }
    }
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }
        Node temp = front;
        System.out.print("Queue: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }
    public static void main(String[] args) {
        DAA_A4_QueueCircularLL queue = new DAA_A4_QueueCircularLL();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();

        queue.dequeue();
        queue.display();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); 
    }
}
