package cn.com.xvym.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Xv
 * @Date: 2021/12/29 23:31
 * @Title: 最长重复子数组
 * @Link: https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * @Tag: 滑动窗口、动态规划
 */
@Slf4j
public class Lc718Test {

    @Test
    public void test() {
        log.info("{}", findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    public int findLength(int[] nums1, int[] nums2) {
        int[] longArr = nums1.length >= nums2.length ? nums1 : nums2;
        int[] shortArr = Arrays.equals(longArr, nums1) ? nums2 : nums1;
        int res = 0;
        // 短数组在长数组右侧
        for (int i = 0; i < shortArr.length; i++) {
            int shortStart = 0;
            int longStart = longArr.length - 1 - i;
            int len = i + 1;
            int temp = doMatch(longArr, shortArr, longStart, shortStart, len);
            res = Math.max(temp, res);
        }

        // 短数组在长数组中间
        for (int i = longArr.length - shortArr.length; i >= 0; i--) {
            int shortStart = 0;
            int longStart = i;
            int len = shortArr.length;
            int temp = doMatch(longArr, shortArr, longStart, shortStart, len);
            res = Math.max(temp, res);
        }

        //短数组在长数组左侧
        for (int i = 0; i < shortArr.length; i++) {
            int shortStart = i;
            int longStart = 0;
            int len = shortArr.length - i;
            int temp = doMatch(longArr, shortArr, longStart, shortStart, len);
            res = Math.max(temp, res);
        }
        return res;
    }

    public int doMatch(int[] nums1, int[] nums2, int start1, int start2, int len) {
        int matchLen = 0;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[start1 + i] == nums2[start2 + i]) {
                temp++;
                matchLen = Math.max(temp, matchLen);
            } else {
                temp = 0;
            }
        }
        return matchLen;
    }
}
