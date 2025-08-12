class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top;

    public ArrayStack(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top >= maxSize - 1) {
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = value;
            System.out.println("Pushed: " + value);
        }
    }

    public void pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println("Popped: " + stack[top--]);
        }
    }

    public void display() {
        if (top < 0) {
            System.out.println("Stack is Empty");
        } else {
            System.out.print("Stack Elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}

public class DAA_A3_StackArray {
    public static void main(String[] args) {
        System.out.println("=== Stack Using Array ===");
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        arrayStack.push(40);
        arrayStack.push(50);
        arrayStack.display();
        arrayStack.pop();
        arrayStack.display();

    }
}

