package everyday;

import java.util.*;

/**
 * @Author szl
 * @Date 2021/9/16 10:53
 * @Description 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，
 * 找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 * words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 */
public class p916 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> strings = new HashSet<>(Arrays.asList(words));
        ArrayList<String> res = new ArrayList<>();
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(strings, res, i, j, m, n, board, used, new StringBuilder());
            }
        }
        return res;
    }

    private void dfs(Set<String> words, List<String> res, int i, int j, int m, int n, char[][] board, boolean[][] used, StringBuilder sb) {
        if (sb.length() > 10)
            return;
        used[i][j] = true;
        sb.append(board[i][j]);
        if (words.contains(sb.toString())) {
            res.add(sb.toString());
            words.remove(sb.toString());
        }
//        used[i][j] = true;
        for (int[] direction : DIRECTIONS) {
//            System.out.println(sb);
            int new_i = i + direction[0];
            int new_j = j + direction[1];
            if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && !used[new_i][new_j]) {
                dfs(words, res, new_i, new_j, m, n, board, used, sb);
            }
//        used[i][j] = false;
        }
        sb.deleteCharAt(sb.length() - 1);
        used[i][j] = false;
    }

    public static void main(String[] args) {
        p916 p916 = new p916();
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}};
        System.out.println(p916.findWords(board, new String[]{"oath", "pea", "eat", "rain"}));
    }
}
