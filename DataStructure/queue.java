class Queue {
  ListNode head;
  ListNode tail;
  
  public class ListNode {
    int value;
    ListNode next;
    public ListNode(int value) {
      this.value = value;
      this.next = null;
    }
  }
  
  public Queue() {
    head = tail = null;
  }
  
  public Integer poll() { //从头上出
    if(head == null) {
      return null;
    }
    ListNode node = head;
    head = head.next;
    if(head == null) {
      tail = null;
    }
    node.next = null;
    return node.value;
  }
  
  public Integer peek() {
    if(head == null) {
      return null;
    }
    return head.value;
  }
  
  public void offer(Integer ele) {
    if(head == null) {
      head = new ListNode(ele);
      tail = head;
    } else {
      tail.next = new ListNode(ele);
      tail = tail.next;
    }
  }
}
