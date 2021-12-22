package cn.com.xvym.algorithm.leetcode;

import org.junit.Test;

/**
 * @Author: Xv
 * @Date: 2021/12/21 22:46
 * @Link: https://leetcode-cn.com/problems/implement-rand10-using-rand7/
 * @Tag: 其他
 */
public class Lc470Test {

    @Test
    public void test() {

    }

    public int rand10() {
        int num = (rand7() - 1) * 7 + rand7();
        while (num > 10) {
            num = (rand7() - 1) * 7 + rand7();
        }
        return num;
    }

    public int rand7() {
        return 0;
    }
}
