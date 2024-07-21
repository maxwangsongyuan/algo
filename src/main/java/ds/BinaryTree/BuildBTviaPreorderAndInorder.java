package ds.BinaryTree;

import java.util.Arrays;

public class BuildBTviaPreorderAndInorder {

    /*
                        1
                      /   \
                     2     3
                   /     /   \
                   4     5     6




       preOrder = {1,2,4,3,6，7}
       inOrder = {4,2,1,6,3,7}

       根 1
             pre        in
       左    2，4        4，2
       右    3，6，7     6，3，7

       根 2
       左 4

       根 3
       左 6
       右 7

     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootVal = preorder[0]; // preorder第一个是根节点
        TreeNode root = new TreeNode(rootVal);

        //找到根节点在inorder中的位置
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                // 0 ~ i -1 是左子树
                // i + 1 ~ inorder.length - 1 是右子树
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i); // [4,2]
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length); // [6,3,7]

                // preorder 1 ~ 1 + i - 1 是左子树（长度和inorder的左子数一样）  copyOfRange 最后一个是not inclusive
                // 1 + i ~ preorder.length - 1 是右子树
                int[] preLeft = Arrays.copyOfRange(preorder, 1, 1 + i); // [2,4]
                int[] preRight = Arrays.copyOfRange(preorder, 1 + i, preorder.length); // [3,6,7]

                root.right = buildTree(preRight, inRight);
                root.left = buildTree(preLeft, inLeft);
                break; // 找到了就不用再找了
            }
        }

        return root;
    }

    public static void main(String[] args) {
        BuildBTviaPreorderAndInorder buildBTviaPreorderAndInorder = new BuildBTviaPreorderAndInorder();
        TreeNode root = buildBTviaPreorderAndInorder.buildTree(new int[]{1, 2, 4, 3, 6, 7}, new int[]{4, 2, 1, 6, 3, 7});
        System.out.println(root);
    }
}
