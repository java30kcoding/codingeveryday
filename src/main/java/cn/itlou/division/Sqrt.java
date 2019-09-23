package cn.itlou.division;

/**
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * @author yuanyl
 * @version V1.0
 * @since 2019/9/23 8:28
 **/
public class Sqrt {

    public int mySqrt(int x) {

        int left = 0;
        int right = (x / 2) + 1;

        while (left < right) {
            int mid = (right + left + 1) >>> 1;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(16));
    }


}
