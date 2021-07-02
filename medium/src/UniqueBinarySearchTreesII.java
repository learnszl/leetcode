import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/7/2 10:45
 * @Description 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * <p>
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 */
public class UniqueBinarySearchTreesII {
    public static class TreeNode {
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

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return backtrack(1, n);
    }

    private static List<TreeNode> backtrack(int start, int end) {
        List<TreeNode> all = new ArrayList<>();
        if (start > end) {
            all.add(null);
            return all;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = backtrack(start, i - 1);
            List<TreeNode> rightTrees = backtrack(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    all.add(currTree);
                }
            }
        }
        return all;
    }
    public static void inorder(TreeNode tree,List<Integer> res){
        if (tree == null)
            return;
        inorder(tree.left,res);
        res.add(tree.val);
        inorder(tree.right,res);

    }

    public static void main(String[] args) {
//        List<TreeNode> trees = generateTrees(3);
//        for (TreeNode tree : trees) {
//            ArrayList<Integer> res = new ArrayList<>();
//            inorder(tree,res);
//            System.out.println(res);
//
//        }
        System.out.println(generateTrees(3));


    }
}
