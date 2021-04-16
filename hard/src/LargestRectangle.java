import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.sql.SQLOutput;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author szl
 * @Date 2021/4/15 10:36
 * @Description
 */
public class LargestRectangle {
    public static int largestRectangleArea(int[] heights) {//暴力超时
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            if (min > res)
                res = min;
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < min)
                    min = heights[j];
                int temp = (j - i + 1) * min;
                if (temp > res)
                    res = temp;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{1}));
    }
}
