import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/8/25 21:05
 * @Description 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 */
public class AllPathsFromSourceToTarget {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(graph, 0, graph.length, temp, res);
        return res;
    }

    private static void dfs(int[][] graph, int index, int n, ArrayList<Integer> temp, ArrayList<List<Integer>> res) {
        if (index == n - 1)
            res.add(new ArrayList<>(temp));
        for (int i = 0; i < graph[index].length; i++) {
            temp.add(graph[index][i]);
            dfs(graph, graph[index][i], n, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
    }
}
