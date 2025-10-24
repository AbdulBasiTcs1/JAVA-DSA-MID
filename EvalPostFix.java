class Stack {
    int[] arr;
    int top;

    public Stack(int size) {
        arr = new int[size];
        top = -1;
    }

    public void push(int data) {
        arr[++top] = data;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow!");
            return 0;
        }
        return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int evaluatePostfix(String postfix) {
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            if (Character.isDigit(ch)) {
                push(ch - '0');
            } else if (isOperator(ch)) {
                int val2 = pop();
                int val1 = pop();
                int result = applyOperator(val1, val2, ch);
                push(result);
            }
        }
        return pop();
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    private int applyOperator(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            case '^': return (int) Math.pow(a, b);
        }
        return 0;
    }
}
public class EvalPostFix {
    
}
