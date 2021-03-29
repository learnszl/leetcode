import java.util.*;

/**
 * @Author szl
 * @Date 2021/3/29 15:59
 * @Description
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();//用 char[]会导致hashcode不一样，此处的key必须用String
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.copyValueOf(ch);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
//        Set<String> set = map.keySet();
//        for (String s : set)
//            System.out.println(s);
//        Collection<ArrayList<String>> values = map.values();
//        Iterator<ArrayList<String>> iterator = values.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        return new ArrayList<>(map.values());
//        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
