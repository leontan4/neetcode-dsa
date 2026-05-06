class ListNode {
    ListNode next;
    ListNode prev;
    int key;
    int val;

    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if(!this.map.containsKey(key)){
            return -1;
        }

        ListNode node = this.map.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int val) {
        if(this.map.containsKey(key)){
            ListNode oldNode = map.get(key);
            remove(oldNode);
        }

        ListNode node = new ListNode(key, val);
        this.map.put(key, node);
        add(node);

        if(this.map.size() > this.capacity){
            ListNode deleteNode = this.head.next;
            remove(deleteNode);
            this.map.remove(deleteNode.key);
        }
    }

    public void add(ListNode node){
        ListNode prevNode = this.tail.prev;
        prevNode.next = node;
        node.next = this.tail;
        this.tail.prev = node;
        node.prev = prevNode;
    }

    public void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
