class HashMap {
  static class Node<K, V> {
    final K key;
    V value;
    public Node<K, V>(K key, V value) {
      this.key = key;
      this.value = value;
    }
    // getKey
    // getValue
    // setValue
  }
  static final int DEFAULT_CAPACITY = 16;
  static final float DEFAULT_LOAD_FACTOR = 0.75f;

  private Node<K, V>[] array;
  private float loadFactor;
  private int size;
  
  public HashMap() {
    this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
  }
  
  public HashMap(int capacity, float loadFactor) {
    this.array = (Node<K, V>[])new Node[cap];
    this.size = 0;
    this.loadFactor = loadFactor
  }
  
  public V put(K key, V value) {
    int index = getIndex(key);
    Node<K, V> head = array[index];
    Node<K, V> node = head;
    while(node != null) {
      if(equalsKey(node.key, key)) {
        V res = node.value;
        node.value = value;
        return res;
      }
      node = node.next;
    }
    // if head == null || didn't find key 
    Node<K, V> newHead = new Node(key, value);
    newHead.next = head;
    array[index] = newHead;
    size++;
    if(needRehashing) {
      rehashing();
    }
    return null;
  }
  
  private int getIndex(K key) {
    return hash(key) % array.length;
  }
  
  private int hash(K key) {
    if(key == null) {
      return 0;
    }
    return key.hashCode() & 0x7FFFFFFF;
  }
  
  private boolean equalsKey(K key1, K key2) {
    return key1 == key2 || key1 != null && key1.equals(key2);
  }
  
  private boolean needRehashing() {
    float ratio = (size + 0.0f)/array.length;
    return ratio > loadFactor;
  }



