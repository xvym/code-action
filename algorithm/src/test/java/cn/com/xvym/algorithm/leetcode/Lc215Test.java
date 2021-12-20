package cn.com.xvym.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: 11104353
 * @Date: 2021/12/20 15:11
 * @Link: https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @Tag: 排序
 */
@Slf4j
public class Lc215Test {

    @Test
    public void test() {
        log.info("{}", findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        heapSort(nums, k);
        return nums[length - k];
    }

    public void heapSort(int[] nums, int k) {
        int length = nums.length;
        // 先自底向上进行一轮堆化
        for (int i = length / 2 - 1; i >= 0; i--) {
            buildMaxHeap(nums, i, length);
        }
        int lastIndex = length - 1;
        // 再自顶向下进行一轮堆化
        // 因为只需要找到第K大的数，因此堆化只需要进行K次
        for (int j = 0; j < k; j++) {
            swap(nums, 0, lastIndex);
            lastIndex--;
            buildMaxHeap(nums, 0, lastIndex);
        }
    }

    public void buildMaxHeap(int[] nums, int i, int length) {
        int biggestIndex = i;
        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;
        if (leftIndex < length && nums[leftIndex] > nums[biggestIndex]) {
            biggestIndex = leftIndex;
        }
        if (rightIndex < length && nums[rightIndex] > nums[biggestIndex]) {
            biggestIndex = rightIndex;
        }
        if (biggestIndex != i) {
            swap(nums, biggestIndex, i);
            buildMaxHeap(nums, biggestIndex, length);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}