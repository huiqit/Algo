/*
先找所有的equipment，把它的坐标存在arraylist里；
然后对每个equip，找到所有C的最短距离，并存入cell.distance里；
对每个cell，distance相加，就是到所有E的最短距离；
再来个两层for loop，得到最小的cell
*/
public class Solution {
  class Cell {
    List<Integer> distances;
    public Cell() {
      distances = new ArrayList<>();
    }
  }
  
  public List<Integer> putChair(char[][] gym) {
    int rows = gym.length;
    int cols = gym[0].length;
    Cell[][] position = new Cell[rows][cols]; //position用来存cell accordingly
    
    //找到所有equipments, 放list里
    //((1,2), (3,5)...)
    List<List<Integer>> equipments = new ArrayList<>();
    
    /*
    List<Cell> equipments = new ArrayList<>();
    int k = 0;
    for(int i = 0; i < cols; i++) {
      for(int j = 0; j < rows; j++) {
        if(gym[i][j] == 'E') {
          equipments.add(new Cell(0, k));
          k++;
        }
      }
    }
    */
    //对每个equip算最短距离
    for(int i = 0; i < equipments.size(); i++) {
       distance(equipments.get(i), gym, position, i);
    }
    //对每个cell，把距离加起来
    //同时，比较所有cell的distance，选出最小的那个
    Cell min = position[0][0];
    List<Integer> res = Arrays.asList(0, 0);
    for(int i = 0; i < cols; i++) {
      for(int j = 0; j < rows; j++) {
        Cell curr = position[i][j];
        for(int k = 0; k < curr.distances.size(); k++) {
          curr.distance += curr.distances.get(k);
        }
        if(curr.distance < min.distance) {
          min = curr;
          res.set(0, i);
          res.set(1, j);
        }
      }
    }
    return res;
  }
  
  private void distance(List<Integer> equip, char[][] gym, Cell[][] position, int i) {
    int[]
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>() {
      @Override
      public int compare(Cell c1, Cell c2) {
        
        return Integer.compare(c1.distances[i], c2.distances[i]);
      }
    });
    
    Set<gym> set = new HashSet<>(); //set里能放cell也行吧
    minHeap.offer(equip, 
    
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      
      
      
      
      
      
      

