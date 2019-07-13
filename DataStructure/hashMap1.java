/*
A hashtable implementation of map.

supported operations:
size();
isEmpty();
put(String key, Integer value);
get(String key);
*/

//buckets
class Entry<K, V> { //做为static nested class放在class里最好
	final K key;
	V value;
	Entry<K, V> next;
	Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
}
//数据的base case是constructor
class HashTable {
	Entry<K, V> 
	


