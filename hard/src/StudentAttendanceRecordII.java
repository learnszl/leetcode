/**
 * @Author szl
 * @Date 2021/8/17 10:06
 * @Description 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。
 * 记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 取余 的结果。
 */
public class StudentAttendanceRecordII {
    private static final int M = 1000000007;

    public static int checkRecord(int n) {
        long[] L = new long[n + 1];
        long[] P = new long[n + 1];
        long[] PL = new long[n + 1];
        P[0] = P[1] = L[1] = PL[0] = 1;
        PL[1] = 2;
        for (int i = 2; i <= n; i++) {
            P[i] = (P[i - 1] + L[i - 1]) % M;
            L[i] = (P[i - 1] + P[i - 2]) % M;
            PL[i] = (P[i] + L[i]) % M;
        }
        long res = PL[n];
        for (int i = 0; i < n; i++) {
            long s = (PL[i] * PL[n - 1 - i]) % M;
            res = (res + s) % M;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(checkRecord(10101));
    }
}
