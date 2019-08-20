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

// using bounded array
public class Stack {
  int head;
  int[] array; 
  //int size;
  public Stack(int cap) {
    head = -1;
    //size = 0;
    array = new int[cap];
  }
  
  public Integer pop() {
    if(head = -1) {
      return null;
    }
    Integer res = array[head];
    //head = (head + 1) % array.length;
    head--;
    return res;
    // --> return head == -1 ? null : array[head--];
  }
  
  public Integer top() {
    if(head == -1) {
      return null;
    }
    return array[head];
  }
  
  public boolean push(int ele) {
    if(head == array.length-1) {
      return false;
    }
    head = (head + 1) % array.length;
    array[head] = ele;
    return true;
  }
  
}
