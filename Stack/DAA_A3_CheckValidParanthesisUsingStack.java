import java.util.Stack;
class DAA_A3_CheckValidParanthesisUsingStack {
    private static boolean isMatched(char open, char close) {
        if((open == '(' && close == ')') ||
           (open == '[' && close == ']') ||
           (open == '{' && close == '}')
        )
            return true;
        return false;
    }
    public static boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i < str.length(); i++) {
            if(str.charAt(i) == '(' || str.charAt(i) == '[' || 
               str.charAt(i) == '{') {
                st.push(str.charAt(i));
            }
            else {
                if(st.isEmpty()) return false;
                char ch = st.peek();
                st.pop();
                if(!isMatched(ch, str.charAt(i))) return false;
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        String str = "()[{}()]";
        boolean ans = isValid(str);
       
        if(ans)
            System.out.println("The given string is valid.");
        else 
            System.out.println("The given string is invalid.");
    }
}

