import java.util.Scanner;
public class DAA_A1_ArrayBasicOperations
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];  
        int size = 0;
        System.out.print("Enter number of elements: ");
        size = sc.nextInt();
        for (int i = 0; i < size; i++) 
        {
            System.out.print("Enter element: ");
            arr[i] = sc.nextInt();
        }
        boolean run = true;
        while (run) 
        {
            System.out.println("\nChoose operation:");
            System.out.println("1. Insert at Start");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Given Position");
            System.out.println("5. Delete from Start");
            System.out.println("6. Delete from End");
            System.out.println("7. Delete at Given Position");
            System.out.println("8. Delete by Value");
            System.out.println("9. Display Array");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch) 
            {
                case 1:
                    if (size >= arr.length) 
                    {
                        System.out.println("Array is full!");
                        break;
                    }
                    System.out.print("Enter element to insert at start: ");
                    int ele1 = sc.nextInt();
                    for (int i = size; i > 0; i--) 
                    {
                        arr[i] = arr[i - 1];
                    }
                    arr[0] = ele1;
                    size++;
                    break;

                case 2:
                    if (size >= arr.length) 
                    {
                        System.out.println("Array is full!");
                        break;
                    }
                    System.out.print("Enter element to insert at end: ");
                    arr[size++] = sc.nextInt();
                    break;

                case 3:
                    if (size >= arr.length) 
                    {
                        System.out.println("Array is full!");
                        break;
                    }
                    System.out.print("Enter position (1 to " + (size + 1) + ") and element: ");
                    int pos = sc.nextInt();
                    int ele2 = sc.nextInt();
                    if (pos < 1 || pos > size + 1) 
                    {
                        System.out.println("Invalid position");
                    } 
                    else 
                    {
                        for (int i = size; i >= pos; i--) 
                        {
                            arr[i] = arr[i - 1];
                        }
                        arr[pos - 1] = ele2;
                        size++;
                    }
                    break;

                case 5:
                    if (size == 0) 
                    {
                        System.out.println("Array is empty!");
                    } 
                    else 
                    {
                        for (int i = 0; i < size - 1; i++) 
                        {
                            arr[i] = arr[i + 1];
                        }
                        size--;
                        System.out.println("First element deleted");
                    }
                    break;

                case 6:
                    if (size == 0) 
                    {
                        System.out.println("Array is empty!");
                    } 
                    else 
                    {
                        size--;
                        System.out.println("Last element deleted");
                    }
                    break;

                case 7:
                    System.out.print("Enter position to delete (1 to " + size + "): ");
                    int delPos = sc.nextInt();
                    if (delPos < 1 || delPos > size) 
                    {
                        System.out.println("Invalid position");
                    } 
                    else 
                    {
                        for (int i = delPos - 1; i < size - 1; i++) 
                        {
                            arr[i] = arr[i + 1];
                        }
                        size--;
                        System.out.println("Element deleted at position " + delPos);
                    }
                    break;

                case 8:
                    System.out.print("Enter value to delete: ");
                    int delVal = sc.nextInt();
                    boolean found = false;
                    for (int i = 0; i < size; i++) 
                    {
                        if (arr[i] == delVal) 
                        {
                            for (int j = i; j < size - 1; j++) 
                            {
                                arr[j] = arr[j + 1];
                            }
                            size--;
                            found = true;
                            System.out.println("Value deleted");
                            break;
                        }
                    }
                    if (!found) 
                    {
                        System.out.println("Value not found");
                    }
                    break;

                case 9:
                    System.out.println("Current array:");
                    for (int i = 0; i < size; i++) 
                    {
                        System.out.print(arr[i] + "\t");
                    }
                    System.out.println();
                    break;

                case 0:
                    run = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
