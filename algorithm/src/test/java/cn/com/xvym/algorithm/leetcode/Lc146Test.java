package cn.com.xvym.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Xv
 * @Date: 2021/12/19 21:43
 * @Link: https://leetcode-cn.com/problems/lru-cache/
 * @Tag: 链表、哈希表、设计
 */
@Slf4j
public class Lc146Test {

    @Test
    public void test() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }

    class LRUCache {

        private Map<Integer, DNode> map;
        private int cap;
        private int size;
        private DNode head;
        private DNode tail;

        class DNode {
            public DNode pre;
            public DNode next;
            public int key;
            public int value;
        }

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.cap = capacity;
            this.head = new DNode();
            this.tail = new DNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                DNode node = map.get(key);
                moveToHead(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                DNode node = map.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                if (size == cap) {
                    int deleteKey = removeTail();
                    map.remove(deleteKey);
                } else {
                    size++;
                }
                DNode node = new DNode();
                node.key = key;
                node.value = value;
                addToHead(node);
                map.put(key, node);
            }
        }

        private void moveToHead(DNode node) {
            DNode pre = node.pre;
            DNode next = node.next;
            pre.next = next;
            next.pre = pre;
            addToHead(node);
        }

        private void addToHead(DNode node) {
            DNode next = head.next;
            node.next = next;
            next.pre = node;
            node.pre = head;
            head.next = node;
        }

        private int removeTail() {
            DNode node = tail.pre;
            if (node != head) {
                DNode pre = node.pre;
                tail.pre = pre;
                pre.next = tail;
                return node.key;
            } else {
                return -1;
            }
        }
    }
}
