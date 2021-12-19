package cn.com.xvym.algorithm.leetcode;

import cn.com.xvym.algorithm.model.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: Xv
 * @Date: 2021/12/19 20:45
 * @Link: https://leetcode-cn.com/problems/reverse-linked-list/
 * @Tag: 链表
 */
@Slf4j
public class Lc003Test {

    @Test
    public void test() {
        ListNode head = ListNode.BuildDefaultListNode(5);
        head = reverseList(head);
        while (head != null) {
            log.info("{}", head.val);
            head = head.next;
        }
    }

//    // 迭代
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }

    // 递归
    public ListNode reverseList(ListNode head) {
        return doReserve(null, head);
    }

    public ListNode doReserve(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        } else {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            return doReserve(pre, cur);
        }
    }

}
