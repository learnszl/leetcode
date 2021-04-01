/**
 * @Author szl
 * @Date 2021/4/1 20:56
 * @Description
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
        int maxArrived = 0;
        for (int i = 0; i <= maxArrived; i++) {
            if (maxArrived >= nums.length - 1)
                return true;
            maxArrived = Math.max(maxArrived, i + nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0}));
    }
}
