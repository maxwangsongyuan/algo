package ds.BinaryTree.DFS;

import ds.BinaryTree.TreeNode;

public class DFSRecursion {

        /*
          1
        /   \
       2     3
      /     / \
     4     5   6

    */

    //1 2 4 3 5 6
    static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //4 2 1 5 3 6
    static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // 4 2 5 6 3 1
    static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode
                (1,
                        new TreeNode(2, new TreeNode(4), null),
                        new TreeNode(3, new TreeNode(5), new TreeNode(6))
                );

        DFSRecursion DFSRecursion = new DFSRecursion();
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }


}
