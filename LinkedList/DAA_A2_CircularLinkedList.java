import java.util.Scanner;
class CircularLinkedList 
{
    static class Node 
    {
        int data;
        Node next;
        Node(int d) 
        { 
            this.data = d; 
        }
    }

    Node head = null;

    void insertAtEnd(int data) 
    {
        Node newNode = new Node(data);
        if (head == null) 
        {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head)
            temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
    }

    void insertAtStart(int data) 
    {
        Node newNode = new Node(data);
        if (head == null) 
        {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head)
            temp = temp.next;
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
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
        {
            if (temp.next == head) 
            {
                System.out.println("Invalid index");
                return;
            }
            temp = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteAtStart() 
    {
        if (head == null) return;
        if (head.next == head) 
        {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != head)
            temp = temp.next;
        temp.next = head.next;
        head = head.next;
    }

    void deleteAtEnd() 
    {
        if (head == null) return;
        if (head.next == head) 
        {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != head)
            temp = temp.next;
        temp.next = head;
    }

    void deleteAtPosition(int index) 
    {
        if (index == 0) 
        {
            deleteAtStart();
            return;
        }
        Node temp = head;
        for (int i = 0; temp.next != head && i < index - 1; i++)
            temp = temp.next;
        if (temp.next == head) 
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
            deleteAtStart();
            return;
        }
        Node temp = head;
        while (temp.next != head && temp.next.data != val)
            temp = temp.next;
        if (temp.next == head) 
        {
            System.out.println("Value not found");
            return;
        }
        temp.next = temp.next.next;
    }

    void display() 
    {
        if (head == null) 
        {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (true) 
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            if (temp == head) 
            {
                break;
            }
        }
        System.out.println("(head)");
    }
}

public class DAA_A2_CircularLinkedList 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList cll = new CircularLinkedList();

        while (true) 
        {
            System.out.println("\n--- Circular Linked List ---");
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
                    cll.insertAtStart(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    cll.insertAtEnd(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter position and value: ");
                    cll.insertAtPosition(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    cll.deleteAtStart();
                    break;
                case 5:
                    cll.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter position: ");
                    cll.deleteAtPosition(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Enter value: ");
                    cll.deleteByValue(sc.nextInt());
                    break;
                case 8:
                    cll.display();
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
