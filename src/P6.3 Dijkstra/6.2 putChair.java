public class Solution {
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
    for(int i = 0; i < cols; i++) {
      for(int j = 0; j < rows; j++) {
        if(gym[i][j] == 'E') {
          equipments.add(new Cell(i, j));
        }
        position[i][j] = new Cell(i, j); //必须要initialize position, 否则无法.x/.y，下面拿到position[curr.x][curr.y]那里会出错
      }
    }

    for(int m = 0; m < equipments.size(); m++) {
      dijkstra(equipments.get(m), gym, position, m);
    }
    //对每个cell，把距离加起来
    //同时，比较所有cell的distance，选出最小的那个
    int globalMin = Integer.MAX_VALUE;
    List<Integer> res = Arrays.asList(-1, -1); //找不到return (-1, -1)
    for(int i = 0; i < rows; i++) { //根据语义来，我定义的row就是行数
      for(int j = 0; j < cols; j++) {
        Cell curr = position[i][j];
        if(curr != 'C') {
          continue;
        } //不能放，就直接跳过
        int tmp = 0; //curr cell's distance sum
        for(int m = 0; m < curr.distances.size(); m++) {
          tmp += curr.distances.get(m);
        }
        if(tmp < globalMin) {
          globalMin = tmp;
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
    //注意：我们在下面改的cell都是position里的，cell没问题，但是'E'也是能走路的，所以也得存下到其他'E'的距离，否则会有堵死的C，比如(1, 3)
    //所以把equip先放到position里，以后改的都是position里的了, 且把 distance = 0 放进去
    /*
    [[["C","C","E","O","C"],
      ["C","C","O","C","E"],
      ["C","C","E","E","C"],
      ["C","O","C","E","E"],
      ["C","C","O","C","C"]]]
    */
    equip = position[equip.x][equip.y];
    equip.distances.add(0);
    minHeap.offer(equip);
    //set去重，防止同一个cell被再次放入，第一次放入一定是最短路径了，因为这里长度都相等 =1，如果是不等的路径（比如课上例题）就得再次放入
    //所以放进去的时候就得给distance赋值，offer cell -> pq的时候就要给distance
    //set怎么判断两个cell为相等：override hashCode() and equals()!
    Set<Cell> set = new HashSet<>();
    set.add(equip);
    int rows = gym.length; 
    int cols = gym[0].length; 
    while(!minHeap.isEmpty()) {
      Cell curr = minHeap.poll();
      dist = curr.distances.get(k);

      if(curr.x + 1 < rows && gym[curr.x+1][curr.y] != 'O' && set.add(position[curr.x+1][curr.y])) {
        position[curr.x+1][curr.y].distances.add(dist+1); 
        minHeap.offer(position[curr.x+1][curr.y]);
      }

      if(curr.x - 1 >= 0 && gym[curr.x-1][curr.y] != 'O' && set.add(position[curr.x-1][curr.y])) {
        position[curr.x-1][curr.y].distances.add(dist+1); 
        minHeap.offer(position[curr.x-1][curr.y]);
      }

      if(curr.y + 1 < cols && gym[curr.x][curr.y+1] != 'O' && set.add(position[curr.x][curr.y+1])) {
        position[curr.x][curr.y+1].distances.add(dist+1); 
        minHeap.offer(position[curr.x][curr.y+1]);
      }

      if(curr.y - 1 >= 0 && gym[curr.x][curr.y-1] != 'O' && set.add(position[curr.x][curr.y-1])) {
        position[curr.x][curr.y-1].distances.add(dist+1); 
        minHeap.offer(position[curr.x][curr.y-1]);
      }
    }
  }
}
