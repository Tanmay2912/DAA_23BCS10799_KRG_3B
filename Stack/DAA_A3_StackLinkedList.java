class LinkedListStack {
    class Node {
        int data;
        Node next;
    }

    private Node top = null;

    public void push(int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed: " + value);
    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println("Popped: " + top.data);
            top = top.next;
        }
    }

    public void display() {
        if (top == null) {
            System.out.println("Stack is Empty");
        } else {
            System.out.print("Stack Elements: ");
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class DAA_A3_StackLinkedList {
    public static void main(String[] args) {
        System.out.println("\n=== Stack Using Linked List ===");
        LinkedListStack linkedStack = new LinkedListStack();
        linkedStack.push(10);
        linkedStack.push(20);
        linkedStack.push(30);
        linkedStack.push(40);
        linkedStack.push(50);
        linkedStack.display();
        linkedStack.pop();
        linkedStack.display();
    }
}
