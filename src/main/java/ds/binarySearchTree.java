package ds;

public class binarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        // Base case: root is null or root's value matches the target value
        if (root == null || root.val == val) {
            return root;
        }

        // If the target value is less than the current node's value, search in the left subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            // Otherwise, search in the right subtree
            return searchBST(root.right, val);
        }
    }

    public TreeNode searchBSTiterative(TreeNode root, int val) {
        while (root != null && root.val != val) {
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
