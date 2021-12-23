package cn.com.xvym.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Xv
 * @Date: 2021/12/22 22:20
 * @Title: 复原IP地址
 * @Link: https://leetcode-cn.com/problems/restore-ip-addresses/
 * @Tag: 回溯
 */
@Slf4j
public class Lc093Test {

    @Test
    public void test() {
        for (String ip : restoreIpAddresses("101023")) {
            log.info("{}", ip);
        }
    }

    private Set<String> set = new HashSet<>();

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, "", "", 0, res);
        return res;
    }

    public void backtrack(String s, Integer index, String path, String curSeg, Integer segCount, List<String> res) {
        // 终止递归的条件：索引越界，分段数大于5，当前分段大于255
        if (index > s.length() - 1 || segCount > 4 || (curSeg.length() > 0 && Integer.parseInt(curSeg) > 255)) {
            return;
        }

        curSeg += s.charAt(index);
        if (Integer.parseInt(curSeg) > 255) {
            return;
        }
        if ("0".equals(curSeg)) {
            // 如果等于0，且不是最后一个元素，则直接开启新的分段
            if ( index != s.length() - 1) {
                backtrack(s, index + 1, path + curSeg + ".", "", segCount + 1, res);
            } else {
                if (!set.contains(path + curSeg)) {
                    res.add(path + curSeg);
                    set.add(path + curSeg);
                }
            }
        } else {
            if (segCount == 3) {
                // 如果是最后一个分段
                if (index == s.length() - 1) {
                    if (!set.contains(path + curSeg)) {
                        res.add(path + curSeg);
                        set.add(path + curSeg);
                    }
                }
            } else {
                // 如果不是最后一个分段，有两种处理：1：打点开启下一个分段，2：继续使用当前分段
                backtrack(s, index + 1, path + curSeg + ".", "", segCount + 1, res);
            }
            backtrack(s, index + 1, path, curSeg, segCount, res);
        }
    }
}
