package cn.com.xvym.algorithm.model;

/**
 * @Author: Xv
 * @Date: 2021/12/19 17:21
 * @Description:
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode BuildDefaultListNode(int count) {
        ListNode head = new ListNode();
        ListNode cur = new ListNode();
        ListNode next = new ListNode();
        for (int i = 0; i <= count; i++) {
            cur.val = i;
            if (i == 1) {
                head = cur;
            }
            if (i != count) {
                cur.next = next;
                cur = cur.next;
                next = new ListNode();
            }
        }
        return head;
    }

    public ListNode BuildListNode(int[] nums) {
        ListNode head = new ListNode();
        ListNode cur = new ListNode();
        ListNode next = new ListNode();
        for (int i = 0; i < nums.length; i++) {
            cur.val = i;
            if (i == 0) {
                head = cur;
            }
            if (i != nums.length - 1) {
                cur.next = next;
                cur = cur.next;
                next = new ListNode();
            }
        }
        return head;
    }

}
