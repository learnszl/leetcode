package everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author szl
 * @Date 2021/9/17 9:40
 * @Description 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 */
public class p917 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> temp = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!temp.contains(board[i][j]))
                        temp.add(board[i][j]);
                    else
                        return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Set<Character> temp = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (!temp.contains(board[j][i]))
                        temp.add(board[j][i]);
                    else
                        return false;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> temp = new HashSet<>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] != '.') {
                            if (!temp.contains(board[k][l]))
                                temp.add(board[k][l]);
                            else
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
