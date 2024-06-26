package ds;

import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;
import java.util.*;

public class bfs {

    //queue for bfs
    static class Node {
        int value;
        List<Node> neighbors;

        Node(int value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }
    }

    public void bfs(Node startNode) {
        if (startNode == null) {
            return;
        }

        // Initialize a queue for BFS
        Queue<Node> queue = new LinkedList<>();
        // Set to keep track of visited nodes
        Set<Node> visited = new HashSet<>();

        // Start with the initial node
        queue.add(startNode);
        visited.add(startNode);

        // Process nodes in the queue
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.println("Visited node: " + currentNode.value);

            // Visit all neighbors
            for (Node neighbor : currentNode.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode rightmostNode = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                rightmostNode = currentNode;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // Add the rightmost node of the current level to the result list
            if (rightmostNode != null) {
                result.add(rightmostNode.val);
            }
        }

        return result;
    }

}
