package cn.itlou.sort;

/**
 * 选择排序
 *
 * @author yuanyl
 * @version V1.0
 * @since 2019/8/26 12:50
 **/
public class SelectionSort {

    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        //根据外层循环，依次将内循环的最小值交换到外循环指定下标处
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] ex = {5, 3, 8, 7, 1};
        selectionSort(ex);
        for (int i = 0; i < ex.length; i++) {
            System.out.println(ex[i]);
        }
    }

}
