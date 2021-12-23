package cn.com.xvym.algorithm.leetcode;

import cn.com.xvym.algorithm.model.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xv
 * @Date: 2021/12/20 22:49
 * @Title: 路径总和II
 * @Link: https://leetcode-cn.com/problems/path-sum-ii/
 * @Tag: 回溯、dfs、bfs、树
 */
public class Lc113Test {

    @Test
    public void test() {

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(root, new ArrayList<>(), res, targetSum, 0);
        return res;
    }

    public void backtrack(TreeNode root, List<Integer> path, List<List<Integer>> res, int targetSum, int curSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        curSum += root.val;
        if (curSum == targetSum && root.left == null & root.right == null) {
            List<Integer> temp = new ArrayList<>(path);
            res.add(temp);
        }
        if (root.left != null) {
            backtrack(root.left, path, res, targetSum, curSum);
        }
        if (root.right != null) {
            backtrack(root.right, path, res, targetSum, curSum);
        }
        path.remove(path.size() - 1);
    }

}
