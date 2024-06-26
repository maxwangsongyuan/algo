package ds;

import java.util.Stack;

public class dfs {

    //stack for dfs

    public int maxDepthofBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepthofBinaryTree(root.left);
        int rightDepth = maxDepthofBinaryTree(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or root is one of p or q
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recur for left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null, p and q are in different subtrees
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null value
        return left != null ? left : right;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void dfs(int[][] grid, int x, int y, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || grid[x][y] == 0) {
            return;
        }

        visited[x][y] = true;
        System.out.println("Visited cell: (" + x + ", " + y + ")");

        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            dfs(grid, newX, newY, visited);
        }
    }

    public void dfsiterative(int[][] grid, int startX, int startY) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{startX, startY});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || grid[x][y] == 0) {
                continue;
            }

            visited[x][y] = true;
            System.out.println("Visited cell: (" + x + ", " + y + ")");

            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                stack.push(new int[]{newX, newY});
            }
        }
    }


}
