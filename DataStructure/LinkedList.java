// singly LinkedList
class LinkedList { 
  Node head;
  Node tail;
  
  class Node {
    int vlaue;
    Node next;
    public Node(int value) {
      this.value = value;
      next = null;
    }
  }
  public LinkedList {
    head = null;
    tail = null;
  }
}
    

// double LinkedList
class DLL {
  Node head;
  Node tail; 
  
  class Node {
    int value; //private?
    Node prev;
    Node next;
    Node(int value) {
      this.value = value;
      prev = null;
      next = null;
    }
  }
  
  DLL() {
    head = null;
    tail = null;
  }
  
  Node appendHead(int val) {
    Node newNode = new Node(val);
    if(head == null) {
      tail = newNode;
    } else {
      newNode.next = head;
    }
    head = newNode;
    return head;
  }
  
  Node appendTail(int val) {
    Node newNode = new Node(val);
    if(tail == null) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    tail = newNode;
    return head;
  }
  
  Node insert(int index, int val) {
    // set prev, next
    // maintain head, tail carefully 
    Node newNode = new Node(val);
    if(head == null) {
      head = newNode;
      tail = newNode;
      return head;
    } 
    Node curr = head;
    while(index > 1 && curr != null) {
      curr = curr.next;
      index--;
    }
    //index == 1 || curr == null
    Node nxt = curr.next; // check if 
    curr.next = newNode;
    newNode.prev = curr;
    newNode.next = nxt;
    if(nxt == null) {
      tail = newNode;
    } else {
      nxt.prev = newNode; // . npe!
    }
    return head;
  }
  
  Node remove(int index, int val) {
    // remove in head
    
  }
  
}
