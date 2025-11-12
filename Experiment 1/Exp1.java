package DAA;
import java.util.Scanner;
public class Exp1 {
    public static class Stack<T> {
        private int maxSize;
        private T[] stackArray;
        private int top;

        public Stack(int size) {
            maxSize = size;
            stackArray = (T[]) new Object[maxSize];
            top = -1;
        }

        public void push(T item) {
            if (isFull()) {
                System.out.println("Stack overflow. Cannot push: " + item);
                return;
            }
            stackArray[++top] = item;
        }

        public T pop() {
            if (isEmpty()) {
                System.out.println("Stack underflow. Cannot pop.");
                return null;
            }
            return stackArray[top--];
        }

        public T peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return null;
            }
            return stackArray[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == maxSize - 1;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return;
            }
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Name: Aditya Yadav\nUID: 23BCS10057");
        Scanner sc = new Scanner(System.in);
        Stack<Integer> intStack = new Stack<>(5);
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.display();
        System.out.println("Top element: " + intStack.peek());
        System.out.println("Popped: " + intStack.pop());
        intStack.display();
        System.out.println("Is stack empty? " + intStack.isEmpty());
        System.out.println("Is stack full? " + intStack.isFull());
        sc.close();
    }
}
