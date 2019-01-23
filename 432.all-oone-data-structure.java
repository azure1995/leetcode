class AllOne {
    class node {
        int val;
        Set<String> set;
        node pre;
        node next;

        node(int v) {
            this.val = v;
            this.set = new HashSet<>();
            this.pre = this.next = null;
        }
    }

    node head, tail;
    Map<String, node> map;

    /** Initialize your data structure here. */
    public AllOne() {
        this.head = this.tail = null;
        map = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (head == null || head.val > 1) {
                node newNode = new node(1);
                newNode.next = head;
                if (head != null) {
                    head.pre = newNode;
                }
                head = newNode;
                if (tail == null) {
                    tail = head;
                }
            }
            head.set.add(key);
            map.put(key, head);
        } else {
            node n = map.get(key);
            n.set.remove(key);
            if (n.next == null || n.next.val > n.val + 1) {
                node newNode = new node(n.val + 1);
                newNode.next = n.next;
                if (n.next != null) {
                    n.next.pre = newNode;
                } else {
                    tail = newNode;
                }
                n.next = newNode;
                newNode.pre = n;
            }
            n.next.set.add(key);
            map.put(key, n.next);
            if (n.set.isEmpty()) {
                remove(n);
            }
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data
     * structure.
     */
    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }
        node n = map.get(key);
        n.set.remove(key);
        if (n.val == 1) {
            map.remove(key);
        } else {
            if (n.pre == null || n.pre.val != n.val - 1) {
                node newNode = new node(n.val - 1);
                newNode.pre = n.pre;
                if (n.pre != null) {
                    n.pre.next = newNode;
                } else {
                    head = newNode;
                }
                n.pre = newNode;
                newNode.next = n;
            }
            n.pre.set.add(key);
            map.put(key, n.pre);
        }
        if (n.set.isEmpty()) {
            remove(n);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return head == null ? "" : tail.set.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return tail == null ? "" : head.set.iterator().next();
    }

    private void remove(node n) {
        if (n.pre == null) {
            if (n.next != null) {
                n.next.pre = null;
            }
            head = n.next;
            if (head == null) {
                tail = null;
            }
        } else {
            n.pre.next = n.next;
            if (n.next == null) {
                tail = n.pre;
            } else {
                n.next.pre = n.pre;
            }
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such: AllOne obj = new
 * AllOne(); obj.inc(key); obj.dec(key); String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
