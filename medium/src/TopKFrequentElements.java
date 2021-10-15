import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author szl
 * @Date 2021/8/20 11:16
 * @Description 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
 * 你可以按 任意顺序 返回答案。
 */
public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length <= k)
            return nums;
        int[] res = new int[k];
        int max = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            int value = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, value);
            max = Math.max(value, max);
        }
        ArrayList<Integer>[] frequencyList = new ArrayList[max + 1];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int key : frequencyMap.keySet()) {
            int fre = frequencyMap.get(key);
            if (frequencyList[fre] == null)
                frequencyList[fre] = new ArrayList<>();
            frequencyList[fre].add(key);
        }
//        System.out.println(Arrays.toString(frequencyList));
        for (int i = max; ans.size() < k && i >= 0; i--) {
            if (frequencyList[i] != null)
                ans.addAll(frequencyList[i]);
        }
        for (int i = 0; i < k; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{3, 0, 1, 0}, 1)));
    }
}

