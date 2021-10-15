package codetop;

import java.util.ArrayList;

/**
 * @Author szl
 * @Date 2021/9/23 21:13
 * @Description 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        ArrayList<TreeNode> node = new ArrayList<>();
        helper(root, node);
        TreeNode p = node.get(0);
        for (TreeNode treenode : node) {
            System.out.println(treenode.val);
        }
        for (int i = 1; i < node.size(); i++) {
            p.left = null;
            p.right = node.get(i);
            p = p.right;
        }
    }

    private void helper(TreeNode root, ArrayList<TreeNode> node) {
        if (root == null)
            return;
        node.add(root);
        helper(root.left, node);
        helper(root.right, node);
    }
    public void flatten1(TreeNode root) {
        
    }


}
