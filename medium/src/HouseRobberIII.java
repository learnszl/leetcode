/**
 * @Author szl
 * @Date 2021/8/2 21:51
 * @Description 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */
public class HouseRobberIII {
    /**
     * @param root 根节点
     * @return 层次遍历错误
     */
//    public static int rob(TreeNode root) {
//        if (root == null)
//            return 0;
//        ArrayList<Integer> layerMoney = new ArrayList<>();
//        ArrayDeque<TreeNode> q = new ArrayDeque<>();
//        q.push(root);
//        layerMoney.add(root.val);
//        int layerCount = 1, CurrLayerCount = 0, currLayerMoney = 0;
//        while (!q.isEmpty()) {
//            CurrLayerCount = 0;
//            currLayerMoney = 0;
//            for (int i = 0; i < layerCount; i++) {
//                TreeNode curr = q.getFirst();
//                if (curr.left != null) {
//                    q.addLast(curr.left);
//                    CurrLayerCount++;
//                    currLayerMoney += curr.left.val;
//                }
//                if (curr.right != null) {
//                    q.addLast(curr.right);
//                    CurrLayerCount++;
//                    currLayerMoney += curr.right.val;
//                }
//                q.removeFirst();
//            }
//            layerCount = CurrLayerCount;
//            layerMoney.add(currLayerMoney);
//        }
//        int[] nums = new int[layerMoney.size()];
//        for (int i = 0; i < layerMoney.size(); i++) {
//            nums[i] = layerMoney.get(i);
//        }
//        return robCommon(nums, 0, layerMoney.size());
//    }
//
//    public static int robCommon(int[] nums, int start, int end) {
//        int n = end - start;
//        if (n == 0)
//            return nums[start];
//        int first = nums[start];
//        int second = Math.max(nums[start], nums[start + 1]);
//        int curr;
//        for (int i = start + 2; i < end; i++) {
//            curr = Math.max(second, first + nums[i]);
//            first = second;
//            second = curr;
//        }
//        return second;
//    }
    public static int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private static int[] dfs(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int selected = root.val + left[1] + right[1];
        int noSelect = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{selected, noSelect};
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(rob(root));
    }
}
