import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

/**
 * @Author szl
 * @Date 2021/3/4 21:37
 * @Description
 */
public class IntegerToRoman {
    public static String integerToRoman(int num) {
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> temp = new ArrayList<>();
        HashMap<Integer, String> roman = new HashMap<>() {
            {
                put(1, "I");
                put(2, "II");
                put(3, "III");
                put(4, "IV");
                put(5, "V");
                put(6, "VI");
                put(7, "VII");
                put(8, "VIII");
                put(9, "IX");
                put(10, "X");
                put(20, "XX");
                put(30, "XXX");
                put(40, "XL");
                put(50, "L");
                put(60, "LX");
                put(70, "LXX");
                put(80, "LXXX");
                put(90, "XC");
                put(100, "C");
                put(200, "CC");
                put(300, "CCC");
                put(400, "CD");
                put(500, "D");
                put(600, "DC");
                put(700, "DCC");
                put(800, "DCCC");
                put(900, "CM");
                put(1000, "M");
                put(2000, "MM");
                put(3000, "MMM");

            }
        };
        while (num > 0) {
            temp.add(num % 10);
            num /= 10;
        }
//        System.out.println(temp);
        for (int i = temp.size() - 1; i >= 0; i--) {
            String str = roman.get(temp.get(i) * (int) Math.pow(10, i));
            if (str != null)
                res.append(str);

        }
        return res.toString();


    }

    public static String integerToRoman1(int num) {
        String[] values = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] key = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < key.length; i++) {
            while (num >= key[i]) {
                res.append(values[i]);
                num -= key[i];
            }

        }
        return res.toString();


    }

    public static void main(String[] args) {
        System.out.println(IntegerToRoman.integerToRoman1(1994));

    }
}
