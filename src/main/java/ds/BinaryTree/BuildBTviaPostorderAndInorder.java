package ds.BinaryTree;

import java.util.Arrays;

public class BuildBTviaPostorderAndInorder {

    /*

                        1
                      /   \
                     2     3
                   /     /   \
                   4     5     6



    inOrder = {4,2,1,6,3,7}
    postOrder = {4,2,6,7,3,1}

    根 1     in         post
    左       4，2        4，2
    右       6，3，7     6，7，3

    根 2
    左 4

    根 3
    左 6
    右 7
 */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootVal = postorder[postorder.length -1]; // postorder最后一个是根节点
        TreeNode root = new TreeNode(rootVal);

        //找到根节点在inorder中的位置
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                // 0 ~ i -1 是左子树
                // i + 1 ~ inorder.length - 1 是右子树
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i); // [4,2]
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length); // [6,3,7]

                //postorder 0 ~ i - 1 是左子树（长度和inorder的左子数一样）  copyOfRange 最后一个是not inclusive
                //i ~ postorder.length - 2 是右子树
                int[] postLeft = Arrays.copyOfRange(postorder, 0, i); // [4,2]
                int[] postRight = Arrays.copyOfRange(postorder, i, postorder.length - 1); // [6,3,7]

                root.right = buildTree(inRight,postRight);
                root.left = buildTree(inLeft,postLeft);
                break; // 找到了就不用再找了
            }
        }

        return root;
    }
}
