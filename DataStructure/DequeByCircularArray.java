public class Deque {
  int head;
  int tail;
  int[] array;
  
  //head + 1 == tail: empty
  //head == tail: full
  
  //tail - First
  //head - Last
  
  public Deque(int cap) {
    array = new int[cap];
    head = 0;
    tail = 1;
  }
  
  public void offerFirst(int ele) {
    if(head == tail) {
      resize();
      array[tail++] = ele;
    } else {
      array[tail] = ele;
      tail = tail == array.length ? 0 : tail + 1;
  }
  
  public Integer pollFirst() {
    if((head+1) % array.length == tail) {
      return null;
    } else {
      int res = array[tail-1];
      tail = tail == 0 ? array.length - 1 : tail - 1;
      return res;
  }
  
  public Integer peekFirst() {
    //return (head + 1) % array.length == tail ? null : tail == 0? array[array.length - 1] : array[tail - 1];
    if((head + 1) % array.length == tail) {
      return null;
    }
    //❌return array[tail];
    if(tail == 0) {
      return array[array.length - 1];
    } else {
      return array[tail-1];
    }
  }
  
  public Integer offerLast(int ele) {
    if(head == tail) {
      resize();
      array[head] = ele;
      head = array.length - 1; //??
    }
    if(head == 0) {
      array[head] = ele;
      head = array.length;
    } else {
      array[head--] = ele;
    }
  }
  
  public Integer pollLast() {
    if((head + 1) % array.length == tail) {
      return null;
    }
    if(head == array.length - 1) {
      //Integer res = array[head];
      head = 0;
      return array[head];
    } else {
      return array[++head]; //先++，后return，因为head不存数据，往后移动一个才有数！
    }
  }
  
  public Integer peekLast() {
    if((head + 1) % array.length == tail) {
      return null;
    } 
    if(head == array.length - 1) {
      return array[0];
    } else {
      return array[head+1];
    }
  }
  
  public void resize() {
    int[] newArray = new int[array.length * 1.5];
    //copy head + 1 ~ array末尾
    for(int i = 1; i < array.length - head; i++) {
      newArray[i] = array[head+i];
    }
    // copy array[0] 到 tail
    for(int j = 0; j < tail; j++) {
      newArray[array.length - head + j] = array[j];
    }
    head = 1;
    tail = array.length - 1;
    array = newArray;
  }
}
