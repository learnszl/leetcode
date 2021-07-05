import java.util.ArrayList;

/**
 * @Author szl
 * @Date 2021/7/5 19:37
 * @Description 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ValidateBinarySearchTree {
    long pre = Long.MIN_VALUE;

    /**
     * 中序遍历完成后判断
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> value = new ArrayList<>();
        inOrder(root, value);
        for (int i = 1; i < value.size(); i++) {
            if (value.get(i) <= value.get(i - 1))
                return false;
        }
        return true;
    }

    private void inOrder(TreeNode root, ArrayList<Integer> value) {
        if (root == null)
            return;
        inOrder(root.left, value);
        value.add(root.val);
        inOrder(root.right, value);
    }

    /**
     * 无需遍历完，有当前值小于等于前一个值即终止
     *
     * @param root
     * @return
     */

    public boolean isValidBST1(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left))
            return false;
        if (root.val <= pre)
            return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}


