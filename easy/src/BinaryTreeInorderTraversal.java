import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author szl
 * @Date 2021/6/11 10:14
 * @Description 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {//递归
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {//非递归中序
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root.right);
                root = root.left;
            }
            root = stack.peek();
            stack.pop();
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> res = binaryTreeInorderTraversal.preorderTraversal(root);
        System.out.println(res);
    }
}
