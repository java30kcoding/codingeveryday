package cn.itlou.sort;

/**
 * 递归获得数组最大值
 *
 * @author yuanyl
 * @version V1.0
 * @since 2019/8/28 12:22
 **/
public class GetMax {

    public static int getMax(int[] arr, int L, int R) {

        if (L == R) {
            return arr[L];
        }

        int mid = (L + R) / 2;
        int maxLeft = getMax(arr, L, mid);
        int maxRight = getMax(arr, mid + 1, R);
        return Math.max(maxLeft, maxRight);

    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 8, 3};
        int max = getMax(arr, 0, arr.length - 1);
        System.out.println(max);
    }

}
