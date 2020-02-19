//Design and implement a data structure for Least Recently Used (LRU) cache. It 
//should support the following operations: get and put. 
//
// get(key) - Get the value (will always be positive) of the key if the key exis
//ts in the cache, otherwise return -1. 
//put(key, value) - Set or insert the value if the key is not already present. W
//hen the cache reached its capacity, it should invalidate the least recently used
// item before inserting a new item. 
//
// The cache is initialized with a positive capacity. 
//
// Follow up: 
//Could you do both operations in O(1) time complexity? 
//
// Example: 
//
// 
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4
// 
//
// 
// Related Topics Design


import java.util.Hashtable;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    static class DLinkedNode {
        int value;
        int key;
        DLinkedNode pre;
        DLinkedNode post;
    }

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
    private int count = 0;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode rear;



    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(DLinkedNode node) {
        node.post.pre = node.pre;
        node.pre.post = node.post;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popRear() {
        DLinkedNode pop = rear.pre;
        removeNode(pop);
        return pop;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        rear = new DLinkedNode();
        rear.post = null;

        head.post = rear;
        rear.pre = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.value = value;
            newNode.key = key;

            cache.put(key, newNode);
            addNode(newNode);

            ++count;

            if (count > capacity) {
                cache.remove(popRear().key);
                --count;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
