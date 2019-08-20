public class Stack {
  private ListNode head;
  public Stack() {
    head = null;
  }
  
  public Integer pop() {
    if(head == null) {
      return null;
    }
    ListNode prev = head;
    head = head.next;
    prev.next = null;
    return prev.value;
  }
  
  public Integer peek() {
    if(head == null) {
      return null;
    }
    return head.value;
  }
  
  public void push(int ele) {
    ListNode node = new ListNode(ele);
    node.next = head;
    head = node;
  }
}

// using array
public class Stack {
  int head;
  Integer[] array; 
  //int size;
  public Stack(int cap) {
    head = 0;
    //size = 0;
    array = new Integer[cap];
  }
  
  public Integer pop() {
    if(head = 0) {
      return null;
    }
    Integer res = array[head];
    head = (head + 1) % array.length;
    return res;
  }
  
  public Integer peek() {
    if(head == 0) {
      return null;
    }
    return array[head];
  }
  
  public boolean push(int ele) {
    if(head == array.length) {
      return false;
    }
    head = (head + 1) % array.length;
    array[head] = ele;
    return true;
  }
  
}
