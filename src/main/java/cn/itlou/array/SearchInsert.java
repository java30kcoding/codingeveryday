package cn.itlou.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * @author yuanyl
 * @version V1.0
 * @since 2019/8/29 8:35
 **/
public class SearchInsert {

    //输入: [1,3,5,6], 5
    //输出: 2
    //输入: [1,3,5,6], 2
    //输出: 1
    //输入: [1,3,5,6], 7
    //输出: 4
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        if (len == 0) {
            return -1;
        }
        if (nums[len - 1] < target) {
            return len;
        }
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

}
