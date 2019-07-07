/*
每行 每列 都是sort好的，ascending
minHeap里装什么：可以只装x,y坐标(distance那题)，也可以把value一起装上
*/
public int kth(int[][] matrix, int k) {
  PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
    @Override
    public int compare(List<Integer> point1, List<Integer> point2) {
      int val1 = matrix[point1.get(0)][point1.get(1)];
      int val2 = matrix[point2.get(0)][point2.get(1)];
      if(val1 == val2) {
         return 0;
      }
      return val1 < val2 ? -1 : 1;
    }
  });
  
  List<Integer> curr = Arrays.asList(0, 0);
  minHeap.offer(curr);
  Set<List<Integer>> set = new HashSet<>();
  set.add(curr);
  while(k > 0) {
    curr = minHeap.poll();
    List<Integer> next = Arrays.asList(curr.get(0)+1, curr.get(1));
    if(curr.get(0) + 1 < matrix.length && set.add(next)) { //横坐标
      minHeap.offer(next);
    }
    next = Arrays.asList(curr.get(0), curr.get(1) + 1);
    if(curr.get(1) + 1 < matrix[0].length && set.add(next)) { //注意这里是matrix[0].length 直觉还是准的！纵坐标
      minHeap.offer(next);
    }
    k--;
  }
  int res = matrix[curr.get(0)][curr.get(1)];
  return res;
}
                   
    
    
  
