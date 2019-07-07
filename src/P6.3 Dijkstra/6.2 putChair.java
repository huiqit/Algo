public class Solution {
  /*
  对每个equipment, run dijkstra，找到到所有点的最短距离，并存在点自己的cell-distance里。
  why use dijkstra: when you expand a cell, the shortest distance is determined. 
  这样，对每个equipment做完，比如有3个E，那么每个点里存的这个distances arrayList就是到3个E的最短距离，
  比如{2, 3, 5} means: 当前cell到E1的最短距离为2，到E2的最短距离为3，到E3的最短距离为5.
  把这个arraylist加起来，就是当前点到所有E的最短距离之和
  再用两层循环，找到这个和最小的那个cell。
  */
  class Cell {
    int x;
    int y;
    List<Integer> distances;
    public Cell(int x, int y) {
      this.x = x;
      this.y = y;
      distances = new ArrayList<>();
    }
    @Override
    public boolean equals(Object obj) {
      if(obj == this) {
        return true;
      }
      if(!(obj instanceof Cell)) {
        return false;
      }
      Cell another = (Cell) obj;
      return this.x == another.x && this.y == another.y;
    }
    @Override
    public int hashCode() {
      return x * 101 + y;
    }
  }
  public List<Integer> putChair(char[][] gym) {
    // Write your solution here
    int rows = gym.length;
    int cols = gym[0].length;
    Cell[][] position = new Cell[rows][cols];

    //find all equipments
    List<Cell> equipments = new ArrayList<>();
    int k = 0; //第几个equipment，按照从左到右，从上到下的顺序排号
    for(int i = 0; i < cols; i++) {
      for(int j = 0; j < rows; j++) {
        if(gym[i][j] == 'E') {
          equipments.add(new Cell(i, j));
          k++;
        }
        position[i][j] = new Cell(i, j); //initialize position, 否则无法.x/.y
      }
    }

    for(int m = 0; m < equipments.size(); m++) {
      dijkstra(equipments.get(m), gym, position, m);
    }
    //对每个cell，把距离加起来
    //同时，比较所有cell的distance，选出最小的那个
    Cell min = position[0][0];
    int globalMin = Integer.MAX_VALUE;
    List<Integer> res = Arrays.asList(0, 0);
    for(int i = 0; i < cols; i++) {
      for(int j = 0; j < rows; j++) {
        Cell curr = position[i][j];
        int tmp = 0; //curr cell's distance sum
        for(int m = 0; m < curr.distances.size(); m++) {
          tmp += curr.distances.get(m);
        }
        if(tmp < globalMin) {
          min = curr;
          res.set(0, i);
          res.set(1, j);
        }
      }
    }
    return res;
  }
 
  private void dijkstra(Cell equip, char[][] gym, Cell[][] position, int k) { //k表示是哪个equipment, 在arraylist的index
    //目标：找到原点到gym中其他所有点的最短距离，并存在position里
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>() {
      @Override
      public int compare(Cell c1, Cell c2) {
        return Integer.compare(c1.distances.get(k), c2.distances.get(k)); 
      }
    });
    minHeap.offer(equip);
    //set去重，防止同一个cell被再次放入，第一次放入一定是最短路径了，因为这里长度都相等 =1，如果是不等的路径（比如课上例题）就得再次放入
    //所以放进去的时候就得给distance赋值，offer cell -> pq的时候就要给distance
    Set<Cell> set = new HashSet<>();
    set.add(equip);
    int dist = 0;
    int rows = gym.length; //y
    int cols = gym[0].length; //x
    while(!minHeap.isEmpty()) {
      Cell curr = minHeap.poll();
      if(gym[curr.x][curr.y] == 'E') {
        dist = 0;
      } else {
        dist = curr.distances.get(k);
      }

      if(curr.x + 1 < cols && gym[curr.x+1][curr.y] == 'C' && set.add(position[curr.x+1][curr.y])) {
        position[curr.x+1][curr.y].distances.add(dist+1); 
        minHeap.offer(position[curr.x+1][curr.y]);
      }

      if(curr.x - 1 >= 0 && gym[curr.x-1][curr.y] == 'C' && set.add(position[curr.x-1][curr.y])) {
        position[curr.x-1][curr.y].distances.add(dist+1); 
        minHeap.offer(position[curr.x-1][curr.y]);
      }

      if(curr.y + 1 < rows && gym[curr.x][curr.y+1] == 'C' && set.add(position[curr.x][curr.y+1])) {
        position[curr.x][curr.y+1].distances.add(dist+1); 
        minHeap.offer(position[curr.x][curr.y+1]);
      }

      if(curr.y - 1 >= 0 && gym[curr.x][curr.y-1] == 'C' && set.add(position[curr.x][curr.y-1])) {
        position[curr.x][curr.y-1].distances.add(dist+1); 
        minHeap.offer(position[curr.x][curr.y-1]);
      }

      dist++;
    }

  }

}
