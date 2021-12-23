package cn.com.xvym.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: Xv
 * @Date: 2021/12/23 22:21
 * @Title: 删除有序数组中的重复项
 * @Link: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @Tag: 数组
 */
@Slf4j
public class Lc026Test {

    @Test
    public void test() {
        log.info("{}", removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
