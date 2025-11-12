package DAA;

import java.util.Scanner;

class DoublyLinkedList {
    class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head, tail;

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void deleteFromBeginning() {
        if (head == null)
            return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteFromEnd() {
        if (tail == null)
            return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class CircularLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node tail;

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void deleteFromBeginning() {
        if (tail == null)
            return;
        if (tail.next == tail) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
    }

    public void deleteFromEnd() {
        if (tail == null)
            return;
        if (tail.next == tail) {
            tail = null;
        } else {
            Node current = tail.next;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = tail.next;
            tail = current;
        }
    }

    public void display() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = tail.next;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }
}

public class Exp4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
        System.out.print("Enter size of Doubly Linked List: ");
        int sizeDLL = sc.nextInt();
        System.out.println("Enter " + sizeDLL + " elements for Doubly Linked List:");
        for (int i = 0; i < sizeDLL; i++) {
            dll.insertAtEnd(sc.nextInt());
        }
        System.out.print("Doubly Linked List: ");
        dll.displayForward();
        dll.deleteFromBeginning();
        System.out.print("After deleting from beginning: ");
        dll.displayForward();
        dll.deleteFromEnd();
        System.out.print("After deleting from end: ");
        dll.displayForward();
        CircularLinkedList cll = new CircularLinkedList();
        System.out.print("\nEnter size of Circular Linked List: ");
        int sizeCLL = sc.nextInt();
        System.out.println("Enter " + sizeCLL + " elements for Circular Linked List:");
        for (int i = 0; i < sizeCLL; i++) {
            cll.insertAtEnd(sc.nextInt());
        }
        System.out.print("Circular Linked List: ");
        cll.display();
        cll.deleteFromBeginning();
        System.out.print("After deleting from beginning: ");
        cll.display();
        cll.deleteFromEnd();
        System.out.print("After deleting from end: ");
        cll.display();
        sc.close();
    }
}