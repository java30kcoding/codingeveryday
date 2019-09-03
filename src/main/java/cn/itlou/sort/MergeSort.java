package cn.itlou.sort;

/**
 * 归并排序
 * 数组采用分治的思想，分为两个部分，分别排好序再使用外排排好左右两个结果。
 *
 * @author yuanyl
 * @version V1.0
 * @since 2019/9/3 18:40
 **/
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    /**
     * 递归
     *
     * @param arr
     * @param L
     * @param R
     */
    private static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        //数组折半
        int mid = L - ((R - L) >>> 1);
        sortProcess(arr, L, mid);
        sortProcess(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    /**
     * 外排
     *
     * @param arr
     * @param L
     * @param mid
     * @param R
     */
    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        //外排的左指针
        int p1 = L;
        //右指针
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
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
    }
}