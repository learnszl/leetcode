import java.util.ArrayList;

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
        StringBuilder buffer = new StringBuilder();
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
    public String zigZagConversion1(String s, int numRows) {
        if (numRows <= 1)
            return s;
        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goDown = false;
        for(char c: s.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows - 1)
                goDown = !goDown;
            curRow += goDown ? 1 : -1;

        }
        StringBuilder ans = new StringBuilder();
        for(StringBuilder row : rows){
            ans.append(row);
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        ZigZagConversion conversion = new ZigZagConversion();
        System.out.println(conversion.zigZagConversion1("abcdefghiweiqneimww", 4));
    }

}
