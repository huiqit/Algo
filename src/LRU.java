public class LRU<K, V> {
  static class Node<K, V> {
    Node<K, V> next;
    Node<K, V> prev;
    K key;
    V value;
    Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
    void update(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
  
  private final int cap;
  private Node<K, V> head;
  private Node<K, V> tail;
  private Map<K, Node<K, V>> map;
  
  public LRU(int cap) {
    this.cap = cap;
    map = new HashMap<>();
  }
  
  public void set(K key, V value) {
    Node<K, V> node = null;
    if(map.containsKey(key)) {
      node = map.get(key);
      node.value = value;
      remove(node);
    } else if(map.size() < cap) {
      node = new Node<>(key, value);
    } else {
      remove(tail);
      node = new Node<>(key, value);
    }
    append(node);
  }
  
  private void remove(Node<K, V> node) {
    map.remove(node.key);
    if(node.prev != null) {
      node.prev.next = node.next;
    } 
    if(node.next != null) {
      node.next.prev = node.prev;
    }
    if(node == head) {
      head = head.next;
    } 
    if(node == tail) {
      tail = tail.prev;
    }
    node.next = node.prev = null;
  }
  
  private void append(Node<K, V> node) {
    map.put(node.key, node);
    if(head == null) {
      head = tail = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node;
    }
  }
}
  
  
  
  
  
  
  
    
