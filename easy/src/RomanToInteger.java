import java.util.HashMap;

/**
 * @Author szl
 * @Date 2021/3/10 11:15
 * @Description
 */
public class RomanToInteger {
     public static int romanToInteger(String s){
         int res = 0;
         HashMap<Character,Integer> roman = new HashMap<>();
         roman.put('I',1);
         roman.put('V',5);
         roman.put('X',10);
         roman.put('L',50);
         roman.put('C',100);
         roman.put('D',500);
         roman.put('M',1000);
         for (int i = 0; i < s.length(); i++) {
                 res += roman.get(s.charAt(i));

         }
         for (int i = 0; i < s.length() - 1; i++) {
             if(s.charAt(i) == 'I' && (s.charAt(i+1) == 'V'|| s.charAt(i+1) == 'X'))
                 res -= 2;
             if(s.charAt(i) == 'X' && (s.charAt(i+1) == 'L'|| s.charAt(i+1) == 'C'))
                 res -= 20;
             if(s.charAt(i) == 'C' && (s.charAt(i+1) == 'D'|| s.charAt(i+1) == 'M'))
                 res -= 200;
         }
         return res;

     }

    public static void main(String[] args) {
        System.out.println(RomanToInteger.romanToInteger("IX"));

    }
}
