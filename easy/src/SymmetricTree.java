/**
 * @Author szl
 * @Date 2021/7/8 10:36
 * @Description 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return judgeSymmetric(root.left, root.right);
    }

    private boolean judgeSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null)
            return t1 == null && t2 == null;
        if (t1.val != t2.val)
            return false;
        return judgeSymmetric(t1.left, t2.right) && judgeSymmetric(t1.right, t2.left);
    }
}
