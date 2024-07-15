package ds.BinaryTree.DFS;

import ds.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class DFSNonRecursion {
    // use stack -> linkedlist

    /*

          1
        /   \
       2     3
      /     / \
     4     5   6

    */


    static void universalTemplate(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root; // 当前节点
        TreeNode pop = null; // 记录上一个弹出的节点
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                colorPrint("前：" + cur.val + " ", 31); // 处理左子树前打印前序遍历
                cur = cur.left; //处理左子树
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null) { //没有右子树
                    colorPrint("中：" + peek.val + " ", 32); // 处理右子树前打印中序遍历
                    pop = stack.pop();
                    colorPrint("后：" + pop.val + " ", 34); // 处理右子树后打印后序遍历
                } else if (peek.right == pop) { //右子树已经处理过
                    pop = stack.pop();
                    colorPrint("后：" + pop.val + " ", 34); // 处理右子树后打印后序遍历
                } else {
                    colorPrint("中：" + peek.val + " ", 32); // 处理右子树前打印中序遍历
                    cur = peek.right; //待处理右子树
                }

            }
        }
    }

    static void preOrder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                colorPrint("去：" + cur.val + " ", 31);
                stack.push(cur); //加入stack， 记住回来的路
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
//                colorPrint("回：" + pop.val + " ", 34);
                cur = pop.right;
            }
        }
    }


    static void inOrder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
//                colorPrint("去：" + cur.val + " ", 31);
                stack.push(cur); //加入stack， 记住回来的路
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                colorPrint("回：" + pop.val + " ", 34);
                cur = pop.right;
            }
        }
    }

    static void postOrder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pop = null; // 记录上一个弹出的节点
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
//                colorPrint("去：" + cur.val + " ", 31);
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                    colorPrint("回：" + pop.val + " ", 34);
                } else { // 有右子树
                    cur = peek.right;
                }

            }
        }
    }

    //method 2
    static void preorderTraversal(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.val + " ");

            // Push right child first so that left is processed first
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode
                (1,
                        new TreeNode(2, new TreeNode(4), null),
                        new TreeNode(3, new TreeNode(5), new TreeNode(6))
                );

        preOrder(root);
        System.out.println("-----------------");
        inOrder(root);
        System.out.println("-----------------");
        postOrder(root);
        System.out.println("-----------------");
        universalTemplate(root);

    }

    private static void colorPrint(String s, int color) {
        System.out.println("\u001B[" + color + "m" + s + "\u001B[0m");
    }
}
