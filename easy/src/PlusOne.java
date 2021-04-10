import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/4/10 10:49
 * @Description
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int i;
        for (i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9)
                digits[i] = 0;
            else
                break;
        }
        if (i == -1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        } else
            digits[i] = digits[i] + 1;
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9})));
    }

}
