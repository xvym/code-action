package cn.com.xvym.algorithm.leetcode;

import org.junit.Test;

/**
 * @Author: 11104353
 * @Date: 2021/12/21 15:02
 * @LinK: https://leetcode-cn.com/problems/delete-and-earn/
 * @Tag: 动态规划
 */
public class Lc740Test {

    @Test
    public void test() {
        deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4});
    }

    public int deleteAndEarn(int[] nums) {
        int[] temp = new int[10001];
        for (int num : nums) {
            temp[num] += num;
        }
        int[] dp = new int[10001];
        dp[0] = 0;
        dp[1] = temp[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], temp[i] + dp[i - 2]);
        }
        return dp[dp.length - 1];
    }
}