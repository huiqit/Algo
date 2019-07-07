/*
Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.
每次变化的都可在原s上：*3, *5, *7
*/

public long kth(int k) {
  PriorityQueue<Long> minHeap = new PriorityQueue<>();
  Set<Long> set = new HashSet<>();
  minHeap.offer(3*5*7l);
  set.add(3*5*7l);
  
  while(k > 1) {
    long curr = minHeap.poll();
    if(set.add(curr*3)) {
      minHeap.offer(curr*3);
    }
    if(set.add(curr*5)) {
      minHeap.offer(curr*5);
    }
    if(set.add(curr*7)) {
      minHeap.offer(curr*7);
    }
    k--;
  }
  return minHeap.peek();
}
