/*
组成部分
1. a table/array of buckets
2. key -> hash function -> index -> hash table
3. collision control - separate chaining -> single linked list

Operations:
1. put(key, value)
2. get(key)
*/
//1. define the class for each entry
//the elements in the buckets, each node contains one <key, value> pair
class Entry<K, V> {
  final K key;
  V value;
  Entry<K, V> next;
  Entry(K key, V value) {
    this.key = key;
    this.value = value;
  }
  //这是Entry里面的API！有了一个Entry，就能get它的key和value！
  public K getKey() {
    return key;
  }
  public V getValue() {
    return value;
  }
  public void setValue(V value) {
    this.value = value;
  }
}

//2. matain an array of entries
Entry<K, V>[] array;

//3. Operations
/*
1. hash(key) to hash# by using hashCode();
2. hash# to entry index in the array;
3. iterate the linked list.
*/
//1.
private int hash(K key) {
  if(key == null) { //hashMap can only has 1 null key, and always mapped to buckect 0.
    return 0;
  }
  int hashNumber = key.hashCode(); 
}
//2.
int getIndex(int hashNumber) {
  return hashNumber % array.length;
}
//3.
Entry<K, V> cur = array[index];
while (curr != null) {
  K curKey = curr.getKey();
  if(curKey is the same as given key) {  
    ...
  }
  curr = curr.next;
}

/*
key.hashCode() -> determine the entry index for the key
key.equals() -> determine whether two keys are the same key
*/











