import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author szl
 * @Date 2021/7/12 16:37
 * @Description 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 */
public class ConstructBinaryTreePreIn {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        Integer index = map.get(preorder[0]);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }


    public static void main(String[] args) {
        ConstructBinaryTreePreIn sbt = new ConstructBinaryTreePreIn();
        System.out.println(sbt.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
