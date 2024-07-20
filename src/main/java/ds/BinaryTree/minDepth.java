package ds.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class minDepth {
    // recursion
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (leftDepth == 0 ) {
            return rightDepth + 1;
        }

        if (rightDepth == 0) {
            return leftDepth + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }

    //bfs
    public int minDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            maxDepth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                //if there is no left and right child, then it is a leaf node
                if (node.left == null && node.right == null) {
                    return maxDepth;
                }
            }


        }

        return maxDepth;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode
                (1,
                        new TreeNode(2, new TreeNode(4), null),
                        new TreeNode(3, new TreeNode(5), new TreeNode(6))
                );

        minDepth minDepth = new minDepth();
        System.out.println(minDepth.minDepth(root));

        System.out.println(minDepth.minDepth2(root));
    }
}
