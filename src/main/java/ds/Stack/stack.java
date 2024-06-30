package ds.Stack;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
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

    /**
     * leetcode 225
     * Implement the following operations of a stack using queues.
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * empty() -- Return whether the stack is empty
     *
     * 解题思路：
     * 用一个队列实现栈
     * push(x) 时，先把队列中的先取出，
     * 然后再把x加入队列， 再把之前取出的元素加入队列
     */
    class MyStack {
        Queue<Integer> queue;
        int size = 0;
        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
            size++;
        }

        public int pop() {
            size--;
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
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
