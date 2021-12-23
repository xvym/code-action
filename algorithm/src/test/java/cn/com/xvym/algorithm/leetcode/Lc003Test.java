package cn.com.xvym.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 11104353
 * @Date: 2021/12/20 11:50
 * @Title: 无重复字符的最长子串
 * @Link: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Tag: 滑动窗口、哈希表
 */
@Slf4j
public class Lc003Test {

    @Test
    public void test() {
        log.info("{}", lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            res = Math.max(res, i - start + 1);
            map.put(s.charAt(i), i);
        }
        return res;
    }
}