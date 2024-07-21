package ds.BinaryTree;

import java.util.LinkedList;

public class ExpressionTree {

    static class TreeNode {
        public String val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }

        public TreeNode(String val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    /*
           中缀表达式     （2-1）*3
           后缀表达式      21-3*

           栈
           1. 遇到数字入栈
           2. 遇到运算符出栈， 建立节点关系，再入栈

           栈
           ｜   ｜
           ｜   ｜
           ｜   ｜
           ------

           ’-‘ . right = 1
           '-' . left = 2

           '*'. right = 3
           '*'. left = '-'

           表达式树
              *
            /   \
           -     3
         /   \
        2     1

        将表达式树后序遍历就是原后缀表达式

    */

    public TreeNode constructExpressionTree(String[] tokens){

        LinkedList<TreeNode> stack = new LinkedList<>();

        for (String t : tokens) {
            switch (t) {
                case "+", "-", "*", "/": //运算符 operand
                    TreeNode parent = new TreeNode(t);
                    parent.right = stack.pop(); // the right child is the first operand
                    parent.left = stack.pop(); // the left child is the second operand
                    stack.push(parent); // parent could be an operand for another operator
                    break;
                default: //数字
                    stack.push(new TreeNode(t));
            }
        }

        return stack.peek();
    }
}
