import java.util.Scanner;
class SinglyLinkedList 
{
    static class Node 
    {
        int data;
        Node next;
        Node(int d) 
        { 
            this.data = d;
            this.next = null; 
        }
    }

    Node head = null;

    void insertAtStart(int data) 
    {
        Node newNode = new Node(data);
        newNode.next = head;
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
        {
            temp = temp.next;
        }
        temp.next = newNode;
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
        temp.next = newNode;
    }

    void deleteAtStart() 
    {
        if (head != null)
        {
            head = head.next;
        }
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
        while (temp.next.next != null)
        {
            temp = temp.next;
        }
        temp.next = null;
    }

    void deleteAtPosition(int index) 
    {
        if (index == 0) 
        {
            deleteAtStart();
            return;
        }
        Node temp = head;
        for (int i = 0; temp != null && i < index - 1; i++)
            temp = temp.next;
        if (temp == null || temp.next == null) 
        {
            System.out.println("Invalid index");
            return;
        }
        temp.next = temp.next.next;
    }

    void deleteByValue(int val) 
    {
        if (head == null) return;
        if (head.data == val) 
        {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != val)
            temp = temp.next;
        if (temp.next != null)
            temp.next = temp.next.next;
        else
            System.out.println("Value not found");
    }

    void display() 
    {
        Node temp = head;
        while (temp != null) 
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class DAA_A2_LinkedList 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList sll = new SinglyLinkedList();

        while (true) 
        {
            System.out.println("\n--- Singly Linked List ---");
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
                    sll.insertAtStart(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    sll.insertAtEnd(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter position and value: ");
                    sll.insertAtPosition(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    sll.deleteAtStart();
                    break;
                case 5:
                    sll.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter position: ");
                    sll.deleteAtPosition(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Enter value: ");
                    sll.deleteByValue(sc.nextInt());
                    break;
                case 8:
                    sll.display();
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

