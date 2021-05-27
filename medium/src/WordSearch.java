
/**
 * @Author szl
 * @Date 2021/5/26 10:02
 * @Description 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class WordSearch {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static boolean exist(char[][] board, String word) {
        char[] charArray = word.toCharArray();
        int m = board.length, n = board[0].length, len = word.length();
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, charArray, used, m, n, i, j, len, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, char[] word, boolean[][] used, int m, int n, int x, int y, int len, int begin) {
        if (begin == len - 1)
            return board[x][y] == word[begin];
        if (board[x][y] == word[begin]) {
            used[x][y] = true;
            for (int[] dir : DIRECTIONS) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if ((newX >= 0 && newX < m && newY >= 0 && newY < n) && !used[newX][newY]) {
                    if (dfs(board, word, used, m, n, newX, newY, len, begin + 1))
                        return true;
                }
            }
            used[x][y] = false;
        }
        return false;
    }
//    public static boolean exist(char[][] board, String word) {
//        int m = board.length, n = board[0].length;
//        boolean[][] used = new boolean[m][n];
//        ArrayList<String> res = new ArrayList<>();
//        System.out.println(m);
//        System.out.println(n);
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                backtrack(res,board,word,used,m,n,i,j,new StringBuffer());
//            }
//        }
//        return res.size() !=0;
//    }
//
//    private static void backtrack(ArrayList<String> res, char[][] board, String word, boolean[][] used, int m, int n, int mIndex, int nIndex, StringBuffer sb) {
//        if (sb.toString().equals(word)) {
//            System.out.println(sb.toString());
//            res.add(sb.toString());
//        }
//        System.out.println(sb.toString());
//        if (mIndex < m - 1) {
//            if (!used[mIndex][nIndex]) {
//                sb.append(board[mIndex][nIndex]);
//                used[mIndex][nIndex] = true;
//                backtrack(res, board, word, used, m, n, mIndex + 1, nIndex, sb);
//                used[mIndex][nIndex] = false;
//                sb.deleteCharAt(sb.length() - 1);
//            }
//        }
//        if (nIndex < n - 1) {
//            if (!used[mIndex][nIndex]) {
//                sb.append(board[mIndex][nIndex]);
//                used[mIndex][nIndex] = true;
//                backtrack(res, board, word, used, m, n, mIndex, nIndex + 1, sb);
//                used[mIndex][nIndex] = false;
//                sb.deleteCharAt(sb.length() - 1);
//            }
//        }
//        if (mIndex > 0) {
//            if (!used[mIndex][nIndex]) {
//                sb.append(board[mIndex][nIndex]);
//                used[mIndex][nIndex] = true;
//                backtrack(res, board, word, used, m, n, mIndex - 1, nIndex, sb);
//                used[mIndex][nIndex] = false;
//                sb.deleteCharAt(sb.length() - 1);
//            }
//        }
//        if (nIndex > 0) {
//            if (!used[mIndex][nIndex]) {
//                sb.append(board[mIndex][nIndex]);
//                used[mIndex][nIndex] = true;
//                backtrack(res, board, word, used, m, n, mIndex, nIndex - 1, sb);
//                used[mIndex][nIndex] = false;
//                sb.deleteCharAt(sb.length() - 1);
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A'}}, "A"));
    }
}
