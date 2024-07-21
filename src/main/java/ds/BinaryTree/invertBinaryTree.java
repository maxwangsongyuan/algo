package ds.BinaryTree;

public class invertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        invert(root);

        return root;
    }

    public void invert(TreeNode root) {
        if (root == null) {
            return;
        }

        //swap left and right
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //recursion
        invert(root.left);
        invert(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode
                (1,
                        new TreeNode(2, new TreeNode(4), null),
                        new TreeNode(3, new TreeNode(5), new TreeNode(6))
                );

        invertBinaryTree invertBinaryTree = new invertBinaryTree();
        TreeNode result = invertBinaryTree.invertTree(root);
        System.out.println(result);
    }

}
