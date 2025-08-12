import java.util.Scanner;
class DoublyLL 
{
    static class Node 
    {
        int data;
        Node prev,next;
        Node(int d) 
        { 
            this.data = d;
            this.prev = null;
            this.next = null; 
        }
    }

    Node head = null;

    void insertAtStart(int data) 
    {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;
    }

    void insertAtEnd(int data) 
    {
        Node newNode = new Node(data);
        if (head == null) 
        {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    void insertAtPosition(int index, int data) 
    {
        if (index == 0) 
        {
            insertAtStart(data);
            return;
        }
        Node temp = head;
        for (int i = 0; temp != null && i < index - 1; i++)
            temp = temp.next;
        if (temp == null) 
        {
            System.out.println("Invalid index");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        if (temp.next != null)
        {
            temp.next.prev = newNode;
        }
        newNode.prev = temp;
        temp.next = newNode;
    }

    void deleteAtStart() 
    {
        if (head == null) return;
        head = head.next;
        if (head != null) head.prev = null;
    }

    void deleteAtEnd() 
    {
        if (head == null) return;
        if (head.next == null) 
        {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.prev.next = null;
    }

    void deleteAtPosition(int index) 
    {
        if (index == 0) 
        {
            deleteAtStart();
            return;
        }
        Node temp = head;
        for (int i = 0; temp != null && i < index; i++)
            temp = temp.next;
        if (temp == null) 
        {
            System.out.println("Invalid index");
            return;
        }
        if (temp.prev != null)
            temp.prev.next = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;
    }

    void deleteByValue(int val) 
    {
        Node temp = head;
        while (temp != null && temp.data != val)
            temp = temp.next;
        if (temp == null) 
        {
            System.out.println("Value not found");
            return;
        }
        if (temp.prev != null)
            temp.prev.next = temp.next;
        else
            head = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;
    }

    void display() 
    {
        Node temp = head;
        while (temp != null) 
        {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class DAA_A2_DoublyLinkedList 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        DoublyLL dll = new DoublyLL();

        while (true) 
        {
            System.out.println("\n--- Doubly Linked List ---");
            System.out.println("1. Insert at Start");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete at Start");
            System.out.println("5. Delete at End");
            System.out.println("6. Delete at Position");
            System.out.println("7. Delete by Value");
            System.out.println("8. Display");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) 
            {
                case 1:
                    System.out.print("Enter value: ");
                    dll.insertAtStart(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    dll.insertAtEnd(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter position and value: ");
                    dll.insertAtPosition(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    dll.deleteAtStart();
                    break;
                case 5:
                    dll.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter position: ");
                    dll.deleteAtPosition(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Enter value: ");
                    dll.deleteByValue(sc.nextInt());
                    break;
                case 8:
                    dll.display();
                    break;
                case 0:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}


//My doggle 