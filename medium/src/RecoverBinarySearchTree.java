import java.util.ArrayList;

/**
 * @Author szl
 * @Date 2021/7/6 16:07
 * @Description 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 */
public class RecoverBinarySearchTree {
    ArrayList<Integer> value = new ArrayList<>();
    int x = Integer.MAX_VALUE, y = 0;
    TreeNode t1 = null;
    TreeNode t2 = null;
    boolean flag_x = true;
    boolean flag_y = true;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inorder(root);
        int i;
        for (i = 1; i < value.size(); i++) {
            if (value.get(i) < value.get(i - 1) && flag_x) {
                flag_x = false;
                x = value.get(i - 1);
            }
            if (value.get(i) > x && flag_y) {
                y = value.get(i - 1);
                flag_y = false;
            }
        }
        if (y == 0 && flag_y)
            y = value.get(i - 1);
        System.out.println(value);
        System.out.println(x);
        System.out.println(y);
        recover(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        value.add(root.val);
        inorder(root.right);
    }

    private void recover(TreeNode root) {
        if (root == null)
            return;
        recover(root.left);
        if (root.val == x) {
            t1 = root;
        }
        if (root.val == y)
            t2 = root;
        recover(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        RecoverBinarySearchTree rb = new RecoverBinarySearchTree();
        rb.recoverTree(root);
    }
}
