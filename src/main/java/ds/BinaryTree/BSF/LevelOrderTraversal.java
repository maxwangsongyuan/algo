package ds.BinaryTree.BSF;

import ds.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    /**
     * Given a binary tree, return the level order traversal of its nodes' values.
     * (ie, from left to right, level by level).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * return its level order traversal as:
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     *
     * 思路：
     * 1. 使用队列，先将根节点入队
     * 2. 当队列不为空时，取出队列中的元素，将其左右子节点入队
     * 3. 重复2，直到队列为空
     *
     */
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> res = new LinkedList<>();

        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add(level);
        }

        return res;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.levelOrderTraversal(root);
        System.out.println(levelOrderTraversal.levelOrderTraversal(root));
    }
}
