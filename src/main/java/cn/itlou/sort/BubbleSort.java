package cn.itlou.sort;

/**
 * 冒泡排序
 *
 * @author yuanyl
 * @version V1.0
 * @since 2019/8/26 12:31
 **/
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        //最大值交换到最右边
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] ex = {5, 3, 8, 7, 1};
        bubbleSort(ex);
        for (int i = 0; i < ex.length; i++) {
            System.out.println(ex[i]);
        }
    }

}
