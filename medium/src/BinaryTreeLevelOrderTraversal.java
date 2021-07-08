import java.util.*;

/**
 * @Author szl
 * @Date 2021/7/8 11:06
 * @Description 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        ArrayDeque<TreeNode> node = new ArrayDeque<>();
        node.add(root);
        while (!node.isEmpty()) {
            ArrayList<Integer> layer = new ArrayList<>();
            int size = node.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = node.getFirst();
                layer.add(curr.val);
                if (curr.left != null)
                    node.addLast(curr.left);
                if (curr.right != null)
                    node.addLast(curr.right);
                node.removeFirst();
            }
            res.add(layer);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }
}
