/**
 * @Author szl
 * @Date 2021/4/6 16:57
 * @Description
 */
public class JumpGameII {
    public static int jump(int[] nums) {
        if (nums.length < 2)
            return 0;
        int count = 0, position = nums.length - 1;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    count++;
                    position = i;
                    break;
                }
            }
        }
        return count;
    }

    public static int jump1(int[] nums){
        int N = nums.length;
        int count = 0, maxPosition = 0, end = 0;
        for (int i = 0; i < N - 1; i++) {
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if(i == end){
                System.out.println(end);
                end = maxPosition;
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(jump1(new int[]{2,3,1,1,4}));
    }
}
