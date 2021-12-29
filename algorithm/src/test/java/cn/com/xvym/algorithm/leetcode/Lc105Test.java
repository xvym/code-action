package cn.com.xvym.algorithm.leetcode;

import cn.com.xvym.algorithm.model.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Xv
 * @Date: 2021/12/28 23:49
 * @Description:
 */
@Slf4j
public class Lc105Test {

    @Test
    public void test() {
        log.info("{}", buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    private Map<Integer, Integer> inIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int rootVal = preorder[0];
        int inRootIndex = -1;
        this.inIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndexMap.put(inorder[i], i);
            if (inorder[i] == rootVal) {
                inRootIndex = i;
            }
        }
        return doBuild(preorder, inorder, 0, inRootIndex, 0, inorder.length - 1);
    }

    public TreeNode doBuild(int[] preorder, int[] inorder, int preRootIndex, int inRootIndex, int inStartIndex, int inEndIndex) {
        if (inStartIndex > inEndIndex || inStartIndex < 0 || inEndIndex > inorder.length - 1) {
            return null;
        }
        if (inStartIndex == inEndIndex) {
            TreeNode node = new TreeNode();
            node.val = inorder[inStartIndex];
            return node;
        }
        TreeNode node = new TreeNode();
        node.val = inorder[inRootIndex];
        int leftLength = inRootIndex - inStartIndex;
        int rightLength = inEndIndex - inRootIndex;
        int preLeftIndex = preRootIndex + 1;
        int preRightIndex = preRootIndex + leftLength + 1;
        if (preLeftIndex >= 0 && preLeftIndex < preorder.length) {
            int leftVal = preorder[preLeftIndex];
            int inLeftIndex = inIndexMap.get(leftVal);
            node.left = doBuild(preorder, inorder, preLeftIndex, inLeftIndex, inStartIndex, inRootIndex - 1);
        }
        if (preRightIndex >= 0 && preRightIndex < preorder.length) {
            int rightVal = preorder[preRightIndex];
            int inRightIndex = inIndexMap.get(rightVal);
            node.right = doBuild(preorder, inorder, preRightIndex, inRightIndex, inRootIndex + 1, inRootIndex + rightLength);
        }
        return node;
    }

}
