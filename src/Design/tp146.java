package Design;

import java.util.*;

/**
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；
 *                             如果不存在，则向缓存中插入该组key-value 。
 *                             如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 */
public class tp146 {
    class LRUCache {
        class Node {
            Node prev;
            Node next;
            int key;
            int value;
            Node(){}
            Node(int key, int value){
                this.key = key;
                this.value = value;
            }
        }
        Map<Integer, Node> cache;
        int size ;
        int capacity;
        Node head, tail;
        public LRUCache(int capacity) {
            cache = new HashMap<>();
            this.size = 0;
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) return -1;
            update(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node == null){
                if (size == capacity) {
                    cache.remove(head.next.key, head.next);
                    remove(head.next);
                }
                Node temp = new Node(key, value);
                update(temp);
                cache.put(key,temp);
                size = size == capacity ? size : ++size;
                return;
            }
            node.value = value;
            update(node);
        }
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void update(Node node) {
            if (cache.containsKey(node.key)){
                remove(node);
            }
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}

