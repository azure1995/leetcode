class LFUCache {
    Map<Integer, LRUCache> map;
    int count;
    int capacity;
    LRUCache head, tail;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        this.count = 0;
        this.capacity = capacity;

        this.head = new LRUCache(0);
        this.head.pre = null;

        this.tail = new LRUCache(0);
        this.tail.post = null;

        this.head.post = this.tail;
        this.tail.pre = this.head;
    }

    public void remove(LRUCache node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    public void inc(int key, LRUCache node, DLinkedNode dn) {
        node.removeNode(dn);
        if (node.post.freq != node.freq + 1) {
            LRUCache newNode = new LRUCache(node.freq + 1);
            newNode.addNode(dn);
            node.post.pre = newNode;
            newNode.post = node.post;

            node.post = newNode;
            newNode.pre = node;
            map.put(key, newNode);
        } else {
            node.post.addNode(dn);
            map.put(key, node.post);
        }
    }

    public int get(int key) {
        LRUCache node = map.get(key);
        if (node == null) {
            return -1;
        }
        DLinkedNode dn = node.get(key);
        inc(key, node, dn);
        if (node.count == 0) {
            remove(node);
        }
        return dn.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        LRUCache node = map.get(key);
        if (node == null) {
            DLinkedNode dn = new DLinkedNode(key, value);
            LRUCache tmp = head.post;
            if (head.post.freq != 1) {
                LRUCache newNode = new LRUCache(1);
                newNode.addNode(dn);

                newNode.pre = head;
                newNode.post = head.post;

                head.post.pre = newNode;
                head.post = newNode;
                map.put(key, newNode);
            } else {
                head.post.addNode(dn);
                map.put(key, head.post);
            }
            count++;
            if (count > capacity) {
                int re = tmp.popTail().key;
                if (tmp.count == 0) {
                    tmp.post.pre = tmp.pre;
                    tmp.pre.post = tmp.post;
                }
                map.remove(re);
                count--;
            }
        } else {
            DLinkedNode dn = node.get(key);
            inc(key, node, dn);
            if (node.count == 0) {
                remove(node);
            }
            map.get(key).set(key, value);
        }
    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;

        DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LRUCache {

        Map<Integer, DLinkedNode> cache;
        DLinkedNode head, tail;
        LRUCache pre, post;
        int count;
        int freq;

        public void addNode(DLinkedNode node) {
            node.pre = head;
            node.post = head.post;

            head.post.pre = node;
            head.post = node;

            cache.put(node.key, node);
            count++;
        }

        public void removeNode(DLinkedNode node) {
            DLinkedNode pre = node.pre;
            DLinkedNode post = node.post;

            pre.post = post;
            post.pre = pre;

            cache.remove(node.key);
            count--;
        }

        public DLinkedNode popTail() {
            DLinkedNode res = tail.pre;
            this.removeNode(res);
            return res;
        }

        public DLinkedNode get(int key) {
            return cache.get(key);
        }

        public void set(int key, int value) {
            DLinkedNode dn = cache.get(key);
            dn.value = value;
            cache.put(key, dn);
        }

        public LRUCache(int freq) {
            this.cache = new HashMap<>();
            this.count = 0;
            this.freq = freq;

            this.head = new DLinkedNode(-1, -1);
            this.head.pre = null;

            this.tail = new DLinkedNode(-1, -1);
            this.tail.post = null;

            this.head.post = this.tail;
            this.tail.pre = this.head;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
