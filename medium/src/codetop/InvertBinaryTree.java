package codetop;

/**
 * @Author szl
 * @Date 2021/9/23 20:53
 * @Description 翻转一棵二叉树。
 * 示例：
 * 输入：
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode save = root.left;
        root.right = invertTree(save);
        return root;
    }
    public TreeNode invertTree1(TreeNode root){
        if (root == null)
            return null;
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
}
