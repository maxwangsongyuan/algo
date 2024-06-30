package ds.Deque;

import ds.BinaryTree.TreeNode;

import java.util.*;

public class ZigZagOrder {

    /**
     * leeCode 103. Binary Tree Zigzag Level Order Traversal
     *
     * using Deque
     */
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean odd_level = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>(); //change to Deque (linkedlist is a deque)
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (odd_level) {
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            odd_level = !odd_level; // change the odd_level flag
            res.add(level);
        }

        return res;
    }

    public static void main(String[] args) {
        ZigZagOrder zigZagOrder = new ZigZagOrder();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = zigZagOrder.levelOrderTraversal(root);
        System.out.println(res);
    }
}
