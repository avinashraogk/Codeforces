package cracking.coing.interview.ds;

import java.util.Scanner;
import java.util.Stack;

public class _05_Stacks_Balanced_Brackets {

    private static final Scanner scanner = new Scanner(System.in);
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        while (t-- != 0) {
            String expression = scanner.nextLine();
            stack.clear();
            boolean flag = true;
            for (char c : expression.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                }
                if (c == ')' || c == ']' || c == '}') {
                    if (stack.isEmpty()) {
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                    if (c != reverse(stack.pop())) {
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                }
            }

            if (flag && stack.isEmpty())
                System.out.println("YES");
            else if (flag)
                System.out.println("NO");
        }

        scanner.close();
    }

    static char reverse(char symbol) {
        if (symbol == '(')
            return ')';
        if (symbol == '[')
            return ']';
        return '}';
    }
}
