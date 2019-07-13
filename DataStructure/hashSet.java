//is backed up by a hashMap instance
class HashSet<K> {
  private HashMap<K, Object> map;
  
  private static final Object PRESENT = new Object();
  
  public HashSet() {
    map = new HashMap<Key, Object>();
  }
  
  public boolean contains(K key) {
    return map.containsKey(key);
  }
  
  public boolean add(K key) {
    return map.put(key, PRESENT) == null;
  }
  ...
}
