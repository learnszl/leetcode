import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/3/11 14:32
 * @Description
 */
public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        HashMap<Character, String> phoneNumber = new HashMap<>();
        phoneNumber.put('2', "abc");
        phoneNumber.put('3', "def");
        phoneNumber.put('4', "ghi");
        phoneNumber.put('5', "jkl");
        phoneNumber.put('6', "mno");
        phoneNumber.put('7', "pqrs");
        phoneNumber.put('8', "tuv");
        phoneNumber.put('9', "wxyz");
        backtrack(res, phoneNumber, digits, 0, new StringBuffer());
        return res;
    }

    private static void backtrack(List<String> combinations, HashMap<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
