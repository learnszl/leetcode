import java.util.HashMap;

/**
 * @Author szl
 * @Date 2021/8/30 11:23
 * @Description 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class LRUCache {//超时

    class LinkListNode {
        int key;
        int value;
        LinkListNode pre;
        LinkListNode next;
    }


    private void removeNode(LinkListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(LinkListNode node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(LinkListNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }


    HashMap<Integer, LinkListNode> cache;
    int cpa;
    LinkListNode head, tail;


    public LRUCache(int capacity) {
        cache = new HashMap<>();
        cpa = capacity;
        head = new LinkListNode();
        head.pre = null;
        tail = new LinkListNode();
        tail.next = null;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            moveToHead(cache.get(key));
            return cache.get(key).value;
        } else
            return -1;
    }


    public void put(int key, int value) {
        LinkListNode node = new LinkListNode();
        node.key = key;
        node.value = value;
        if (cache.containsKey(key))
            removeNode(cache.get(key));
        cache.put(key, node);
        addNode(node);
        if (cache.size() > cpa) {
            cache.remove(tail.pre.key);
            removeNode(tail.pre);
        }
    }
}
