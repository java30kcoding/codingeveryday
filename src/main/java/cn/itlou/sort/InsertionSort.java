package cn.itlou.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 最好情况 O(n)
 * 最差情况 O(n2)
 *
 * @author yuanyl
 * @version V1.0
 * @since 2019/8/26 13:00
 **/
public class InsertionSort {

    public static void insertionSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 随机样本产生方法
     *
     * @param size  数组最大长度
     * @param value 最大值
     * @return
     */
    public static int[] generateRandomArray(int size, int value){
        //生成随机长度的数组
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }

    /**
     * 复制数组
     *
     * @param arr 数组
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 判断两数组内容是否相等
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return
     */
    public static boolean isArrayEqual(int[] arr1, int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组内容
     *
     * @param arr 源数组
     */
    public static void printArray(int[] arr){
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int size = 10;
        int value = 100;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            insertionSort(arr1);
            //绝对正确的排序
            Arrays.sort(arr2);
            if (!isArrayEqual(arr1, arr2)) {
                success = false;
                printArray(arr3);
                break;
            }
        }
        System.out.println(success ? "Nice!" : "Fucking Shit!");

        int[] arr = generateRandomArray(size, value);
        printArray(arr);

    }

}
