package ds.Stack;

import java.util.Stack;

public class Calculator {
    /**
     *
     * |   |
     * |   |
     * |   |
     * -----
     *
     * a+b   ab+
     * a+b-c  ab+c-
     * a+b*c  abc*+
     * a*b+c  ab*c+
     * a+b*c-d  abc*+d-
     * (a+b)*c  ab+c*
     * (a+b*c-d)*e abc*+d-*e
     * a*(b+c)  abc+*
     *
     * 1. 遇到非运算符，直接 加到string
     * 2. 遇到运算符  +  - * /，
     *   1. 如果当前优先级小于等于栈顶优先级，弹出栈顶元素，加到string
     *   2. 如果当前优先级大于栈顶优先级，直接入栈
     *   3. 如果是左括号，直接入栈
     *   4. 如果是右括号，弹出栈顶元素，加到string，直到遇到左括号
     *   5. 如果栈为空，直接入栈
     * 如果遍历结束，弹出所有栈顶元素，加到string
     */
    public String infixToSuffixWithParenthesis(String exp) {
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '*', '/', '+', '-' -> {
                    if (s.isEmpty()) { //empty
                        s.push(c);
                    } else {
                        if (precedence(c) <= precedence(s.peek())) { //如果当前优先级小于等于栈顶优先级，弹出栈顶元素，加到string
                            while (!s.isEmpty() && precedence(c) <= precedence(s.peek())) {
                                Character top = s.pop();
                                sb.append(top);
                            }
                            s.push(c);
                        } else {
                            s.push(c); //如果当前优先级大于栈顶优先级，直接入栈
                        }
                    }
                }
                case '(' -> s.push(c);
                case ')' -> {
                    while (!s.isEmpty() && s.peek() != '(') {
                        Character top = s.pop();
                        sb.append(top);
                    }
                    s.pop(); //remove '('
                }
                default -> sb.append(c);
            }
        }

        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        return sb.toString();
    }

    /**
     *
     * |   |
     * |   |
     * |   |
     * -----
     *
     * a+b   ab+
     * a+b-c  ab+c-
     * a+b*c  abc*+
     * a*b+c  ab*c+
     * a+b*c-d  abc*+d-
     * (a+b)*c  ab+c*
     * (a+b*c-d)*e abc*+d-e*
     * a*(b+c)  abc+*
     *
     * 1. 遇到非运算符，直接 加到string
     * 2. 遇到运算符  +  - * /，
     *   1. 如果当前优先级小于等于栈顶优先级，弹出栈顶元素，加到string
     *   2. 如果当前优先级大于栈顶优先级，直接入栈
     *   5. 如果栈为空，直接入栈
     * 如果遍历结束，弹出所有栈顶元素，加到string
     */

    public String infixToSuffix(String exp) {
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '*', '/', '+', '-' -> {
                    if (s.isEmpty()) { //empty
                        s.push(c);
                    } else {
                        if (precedence(c) <= precedence(s.peek())) { //如果当前优先级小于等于栈顶优先级，弹出栈顶元素，加到string
                            while (!s.isEmpty() && precedence(c) <= precedence(s.peek())) {
                                Character top = s.pop();
                                sb.append(top);
                            }
                            s.push(c);
                        } else {
                            s.push(c); //如果当前优先级大于栈顶优先级，直接入栈
                        }
                    }
                }
                default -> sb.append(c);
            }
        }

        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        return sb.toString();
    }

    /**
     * leetcode 150
     * 逆波兰表达式
     * 逆波兰表达式（Reverse Polish Notation，RPN）是一种用于表示算术表达式的记法，
     * 其特点是运算符在操作数的后面。例如，中缀表达式 (1 + 2) * 3 可以写成 1 2 + 3 *。
     * 逆波兰表达式的计算规则如下：
     * 1. 从左到右遍历表达式，遇到数字时，将数字压入堆栈；
     * 2. 遇到运算符时，弹出堆栈顶的两个数字，用运算符对它们进行运算，
     *   并将结果压入堆栈；
     *   例如，遇到 + 运算符时，弹出 2 和 1，计算 1 + 2 = 3，
     *   将 3 压入堆栈。
     *   示例 1：
     *   输入：tokens = ["2","1","+","3","*"]
     *   输出：9
     *   解释：有效的逆波兰表达式是 ["2","1","+","3","*"] 。
     *   其计算结果是 2 + 1 = 3，3 * 3 = 9 。
     *
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+" -> {
                    Integer pop1 = s.pop();
                    Integer pop2 = s.pop();
                    s.push(pop1 + pop2);
                }
                case "-" -> {
                    Integer pop1 = s.pop();
                    Integer pop2 = s.pop();
                    s.push(pop2 - pop1);
                }
                case "*" -> {
                    Integer pop1 = s.pop();
                    Integer pop2 = s.pop();
                    s.push(pop2 * pop1);
                }
                case "/" -> {
                    Integer pop1 = s.pop();
                    Integer pop2 = s.pop();
                    s.push(pop2 / pop1);
                }
                default -> {
                    s.push(Integer.parseInt(tokens[i]));
                }
            }

        }

        return s.pop();
    }

    /**
     * leetcode 224
     * basic calculator
     */
    public int calculate(String s) {
        String trimmed = s.replaceAll("\\s", "");
        if (trimmed.matches("^[0-9]+$")) {
            return Integer.parseInt(trimmed);
        }

        Calculator calculator = new Calculator();


        String suffix = calculator.infixToSuffixWithParenthesis(trimmed);
        System.out.println(suffix);
        String[] tokens = suffix.split("");
        return calculator.evalRPN(tokens);
    }


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.infixToSuffix("a+b"));
        System.out.println(calculator.infixToSuffix("a+b-c"));
        System.out.println(calculator.infixToSuffix("a+b*c"));
        System.out.println(calculator.infixToSuffix("a*b+c"));
        System.out.println(calculator.infixToSuffix("a+b*c-d"));
        System.out.println(calculator.infixToSuffixWithParenthesis("(a+b)*c"));
        System.out.println(calculator.infixToSuffixWithParenthesis("(a+b*c-d)*e"));
        System.out.println(calculator.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(calculator.calculate("1 + 1"));
        System.out.println(calculator.calculate(" 2-1 + 2 "));
        System.out.println(calculator.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculator.calculate("   2147483647"));
    }

    static int precedence(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else {
            return 0;
        }
    }
}
