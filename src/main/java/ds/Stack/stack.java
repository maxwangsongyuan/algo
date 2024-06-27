package ds.Stack;

import java.util.Map;
import java.util.Stack;

public class stack {
    /**
     * leetcode 735
     * 如果行星向右移动（正数），则将其推入堆栈。
     * 如果行星向左移动（负数），则检查与堆栈中的行星（向右移动）的碰撞。
     * 弹出堆栈中的行星，直到当前行星的大小（绝对值）大于堆栈的顶部。
     * 如果堆栈的顶部与当前行星的大小相同，则弹出它，当前行星也将被销毁。
     * 如果当前行星小于堆栈的顶部，则它将被销毁。
     *
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean collision = false;

            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.peek();
                if (Math.abs(asteroid) > top) { //
                    stack.pop();
                    continue;
                } else if (Math.abs(asteroid) == top) {
                    stack.pop();
                }
                collision = true;
                break;
            }

            if (!collision) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }


    /**
     * leetcode 20
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 示例 1：
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     * 输入：s = "(]"
     * 输出：false
     *
     */
    public boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        // Map closing brackets to corresponding opening brackets
        Map<Character, Character> bracketMap = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        for (char c : s.toCharArray()) {
            if (bracketMap.containsValue(c)) {
                // If it's an opening bracket, push to the stack
                stack.push(c);
            } else if (bracketMap.containsKey(c)) {
                // If it's a closing bracket, check the top of the stack
                if (stack.isEmpty() || stack.pop() != bracketMap.get(c)) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets are matched correctly
        return stack.isEmpty();
    }

    /**
     * leetcode 20
     * another way to solve the problem
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
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
                    s.push( Integer.parseInt(tokens[i]));
                }
            }

        }

        return s.pop();
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

    public static void main(String[] args) {
        stack s = new stack();
        System.out.println(s.infixToSuffix("a+b"));
        System.out.println(s.infixToSuffix("a+b-c"));
        System.out.println(s.infixToSuffix("a+b*c"));
        System.out.println(s.infixToSuffix("a*b+c"));
        System.out.println(s.infixToSuffix("a+b*c-d"));
        System.out.println(s.infixToSuffixWithParenthesis("(a+b)*c"));
        System.out.println(s.infixToSuffixWithParenthesis("(a+b*c-d)*e"));
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


    //--------------------------------------------------------------------------------

    /**
     * leetcode 232 Implement a first in first out (FIFO) queue using only two stacks.
     * 队尾插入元素，队首删除元素
     *
     * 队头移除
     * 先把s2 所有元素移动到s1
     */
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack2.push(x);
        }

        public int pop() {
            if(stack1.isEmpty()) {
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
            return stack1.pop();
        }

        public int peek() {
            if(stack1.isEmpty()) {
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }


    //--------------------------------------------------------------------------------

    //For Loop in While Loop:
    //Useful when each element might cause multiple changes to the stack.
    //Example use cases: collisions, nested structures.
    public void processElements1(int[] elements) {
        Stack<Integer> stack = new Stack<>();

        while (!stack.isEmpty() ) {
            for (int element : elements) {
                //do something
            }
        }

        // Final processing of the stack, if needed
    }


    //While Loop in For Loop:
    //Useful when you need to maintain the state and process each element until a condition is met.
    //Example use cases: balanced parentheses, maintaining a monotonous stack.
    public void processElements(int[] elements) {
        Stack<Integer> stack = new Stack<>();

        for (int element : elements) {
            // Directly push the element to the stack if needed
            while (!stack.isEmpty()  ) {  // && someCondition()
                // Process the top of the stack and the current element
                stack.pop();
            }
            // Logic to handle the current element after the while loop
            stack.push(element);
        }

        // Final processing of the stack, if needed
    }


    //Recursion:
    //Useful for problems that can be broken down into smaller subproblems.
    //Example use cases: depth-first search, tree traversals.

    public void processElements2(int[] elements) {
        Stack<Integer> stack = new Stack<>();
        processRecursively(elements, 0, stack);
    }

    private void processRecursively(int[] elements, int index, Stack<Integer> stack) {
        if (index == elements.length) {
            // Base case: all elements processed
            return;
        }

        int element = elements[index];
        // Logic before recursion
        while (!stack.isEmpty() ) { // && someCondition()
            // Process the top of the stack and the current element
            stack.pop();
        }

        // Logic to handle the current element after the while loop
        stack.push(element);

        // Recur to process the next element
        processRecursively(elements, index + 1, stack);
    }
}
