package DAA;

import java.util.Scanner;

class Exp3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("\nElement\tFrequency");
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    visited[j] = true;
                }
            }
            System.out.println(arr[i] + "\t" + count);
        }
        scanner.close();
    }
}
