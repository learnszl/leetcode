

/**
 * @Author szl
 * @Date 2021/3/1 21:28
 * @Description
 */
public class ZigZagConversion {
    public String zigZagConversion(String s, int numRows) {//暴力解法
        if (numRows <= 1)
            return s;
        int size = 2 * numRows - 2;
        int column = s.length() / size * 2 + 2;
        char[][] ans = new char[numRows][column];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < column; j++) {
                ans[i][j] = '*';
            }
        }
        int i = 0;
        for (int j = 0; j < column; j++) {
            if (countColumn(size, i, numRows)) {
                for (int k = 0; k < numRows; k++) {
                    if (i < s.length()) {
                        ans[k][j] = s.charAt(i);
                        i++;
                    } else
                        break;

                }
            } else {
                for (int k = numRows - 2; k > 0; k--) {
                    if (i < s.length()) {
                        ans[k][j] = s.charAt(i);
                        i++;
                    } else
                        break;


                }
            }

        }
        StringBuffer buffer = new StringBuffer();
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < column; k++) {
                if (ans[j][k] != '*') {
                    buffer.append(ans[j][k]);
                }
            }
        }
        return buffer.toString();

    }

    public boolean countColumn(int size, int i, int numRows) {
        return i % size < numRows;


    }

    public static void main(String[] args) {
        ZigZagConversion conversion = new ZigZagConversion();
        System.out.println(conversion.zigZagConversion("abcde", 4));
    }

}
