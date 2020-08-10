package cn.itlou.dp;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * @author yuanyl
 * @date 2020/8/10 8:28
 **/
public class ClaimStairs {

    /**
     * 递归解法f(n) = f(n - 1) + f(n - 2)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    /**
     * 滑动数组 + 动态规划
     *
     * @param n
     * @return
     */
    public int climbStairsByDp(int n) {
        if (n == 1) {
            return n;
        }
        int first = 1;
        int second = 2;
        int third = 3;
        for (int i = 3; i <= n; i++) {
            first = second;
            second = third;
            third = first + second;
        }
        return second;
    }

    public static void main(String[] args) {
        ClaimStairs claimStairs = new ClaimStairs();
        System.out.println(claimStairs.climbStairs(35));
        System.out.println(claimStairs.climbStairsByDp(2));
    }

}
