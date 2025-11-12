package DAA;

public class Exp9 {

    public static void findPattern(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        boolean found = false;

        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);
        System.out.println("\nPattern found at positions:");

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }
            if (j == m) {
                System.out.println("Pattern found at index: " + i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No occurrences found.");
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABAB";
        findPattern(text, pattern);
    }
}
