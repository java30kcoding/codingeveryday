package cn.itlou.example;

/**
 * 在一个数组中，每个数左边比当前数小的数累加起来，叫做这个数组的小和
 *
 * @author yuanyl
 * @version V1.0
 * @since 2019/9/10 18:40
 **/
public class MinSum {

    private static int minSumByForce(int[] arr){
        int res = 0;
        for (int r = 0; r < arr.length; r++) {
            int l = 0;
            while (l < r) {
                if (arr[l] < arr[r]) {
                    res += arr[l];
                }
                l++;
            }
        }
        return res;
    }

    private static int minSumMerge(int[] arr, int L, int R){

        //退出条件
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return minSumMerge(arr, L, mid) + minSumMerge(arr, mid + 1, R) + mergeSort(arr, L, mid, R);

    }

    private static int mergeSort(int[] arr, int L, int mid, int R){
        //临时销毁，临时生成
        int[] help = new int[R - L + 1];
        int i = 0;
        //外排的左指针
        int p1 = L;
        //右指针
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //两个必须有且只有一个越界
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(minSumByForce(arr));
        System.out.println(minSumMerge(arr, 0, 4));
    }

}
