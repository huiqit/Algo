public class BoundedQueue {
  int head;
  int tail;
  int size;
  Integer[] array;
  
  public BoundedQueue(int cap) {
    head = tail = 0;
    size = 0;
    array = new Integer[cap];
  }
  // head poll()
  // tail offer()
  public boolean offer(Integer ele) {
    if(size == array.length) {
      return false;
    }
    array[tail] = ele;
    tail = (tail+1) % array.length;
    // tail = tail + 1 == array.length ? 0 : tail + 1;
    size++;
    return true;
  }
  
  public Integer poll() {
    if(size == 0) {
      return null;
    }
    Integer res = array[head];
    head = (head+1) % array.length;
    size--;
    return res;
  }
  
  public Integer peek() {
    if(size == 0) {
      return null;
    }
    return array[head];
  }
  
  public int size() {
    return size;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  public boolean isFull() {
    return size == array.length;
  }
}
    
    
    
