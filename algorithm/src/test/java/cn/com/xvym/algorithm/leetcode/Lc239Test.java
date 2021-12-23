package cn.com.xvym.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Author: 11104353
 * @Date: 2021/12/22 11:46
 * @Title: 滑动窗口最大值
 * @Link: https://leetcode-cn.com/problems/sliding-window-maximum/
 * @Tag: 优先队列、单调队列、双向队列
 */
@Slf4j
public class Lc239Test {

    @Test
    public void test() {
        for (int num : maxSlidingWindow(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5)) {
            log.info("{}", num);
        }
    }

    // 优先队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((x, y) -> (y[1] - x[1]));
        int start = 0;
        int end = start + k - 1;
        // 处理第一个区间
        for (int i = 0; i < end; i++) {
            Integer[] pair = new Integer[]{i, nums[i]};
            queue.add(pair);
        }
        while (end < nums.length) {
            while (queue.peek()[0] < start) {
                queue.poll();
            }
            Integer[] pair = new Integer[]{end, nums[end]};
            queue.add(pair);
            res[end - k + 1] = queue.peek()[1];
            start++;
            end++;
        }
        return res;
    }
}