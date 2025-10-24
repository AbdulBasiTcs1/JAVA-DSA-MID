import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String infix = input.nextLine();

        Stack stack = new Stack(100);
        String postfix = "";

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix += ch;
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop();
            }
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix += stack.pop();
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        System.out.println("Postfix expression: " + postfix);
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}

class Stack {
    char[] arr;
    int top;

    public Stack(int size) {
        arr = new char[size];
        top = -1;
    }

    public void push(char ch) {
        arr[++top] = ch;
    }

    public char pop() {
        if (top == -1) return '\0';
        return arr[top--];
    }

    public char peek() {
        if (top == -1) return '\0';
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}