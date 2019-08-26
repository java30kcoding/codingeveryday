package cn.itlou.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * @author yuanyl
 * @version V1.0
 * @since 2019/8/26 10:07
 **/
public class TwoSum {

    //给定 nums = [2, 7, 11, 15], target = 9
    //因为 nums[0] + nums[1] = 2 + 7 = 9
    //所以返回 [0, 1]

    /**
     * 使用哈希表实现
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumWithHash(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>(16);

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if(map.containsKey(find) && map.get(find) != i) {
                return new int[] {i, map.get(find)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");

    }

    /**
     * 暴力解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumByForce(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - 1; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[] {i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");

    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ex = {2, 7, 11, 15};
        int[] ints = twoSum.twoSumByForce(ex, 33);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}
