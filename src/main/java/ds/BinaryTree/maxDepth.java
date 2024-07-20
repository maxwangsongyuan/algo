package ds.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class maxDepth {
    /**
     * recursion leetcode 104
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * iteration leetcode 104 dfs postOrder traversal
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root; // 当前节点
        TreeNode pop = null; // 记录上一个弹出的节点
        int maxDepth = 0; // 记录最大深度

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                int size = stack.size();
                if (size > maxDepth) {
                    maxDepth = size;
                }
                cur = cur.left; //处理左子树
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null) { //没有右子树
                    pop = stack.pop();
                } else if (peek.right == pop) { //右子树已经处理过
                    pop = stack.pop();
                } else {
                    cur = peek.right; //待处理右子树
                }

            }
        }

        return maxDepth;
    }

    /**
     * iteration leetcode 104 bfs traversal
     * @param root
     * @return
     */
    public int maxDepth3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
//                System.out.println(node.val + " " + maxDepth);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            maxDepth++;
        }

        return maxDepth;
    }

    /**
     *
     *    1
     *  / \
     *  2  3
     *  /  / \
     *  4  5  6
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode
                (1,
                        new TreeNode(2, new TreeNode(4), null),
                        new TreeNode(3, new TreeNode(5), new TreeNode(6))
                );

        maxDepth maxDepth = new maxDepth();
        System.out.println(maxDepth.maxDepth(root));

        System.out.println(maxDepth.maxDepth2(root));

        System.out.println(maxDepth.maxDepth3(root));
    }


}
