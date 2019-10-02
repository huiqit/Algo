/*
题意：找有多少个island。
什么算1个island: 周围有水（0），matrix外算是水，4个方向连着1的算是连着的陆地。
方法：从任意一个1开始，bfs/dfs search相连的1，mark visited(设为1），并且这些连在一起的1算一个island, count++在主函数里
mark visited: 可以另外开一个int[][] matrix来记录；或者在原图上mark成除了1之外的点，注意：
  如果之后需要恢复原grid，就不能mark成0了，mark成2啊3啊都行。
*/
/*
DFS: O(m*n), 
BFS: O(V+E) 即 O(m*n), 空间复杂度 min(n, m)，queue的最大容量，一圈一圈走的
然而lc提交显示DFS 1s, BFS 3s. 
你recursion 走四个方向对吧，那么你dfs最远可能会走一个螺旋路线，你这样画一下是O(m*n)。
bfs是min(m,n)你每次generate出来的点在queue里最多只能有这么多，你画一个图试着用queue推一下你就会发现generate不出来一层会m*n个点的
*/
/*
dfs的call stack会占多一点，肯定是recursion的压力大;
然后bfs因为要保存在queue里面所以heap会占多点
个人感觉是bfs会好一点，因为recursion都会对call stack有压力
call stack里存的是方法调用的状态，也就会存一些没必要记录的量。
iterative的解法会解决这个问题，你的queue只存你想存的东西即可。
*/

// Assumption: if the grid is invalid, return 0. 
public int numIslands(char[][] grid) {
  if(grid == null || grid.length == 0 || grid[0].length == 0) {
     return 0;
  }
  int count = 0;
  int rows = grid.length;
  int cols = grid[0].length;
  for(int i = 0; i < rows; i++) {
    for(int j = 0; j < cols; j++) {
      if(grid[i][j] == '1') {
        count++;
        // 这里不需要mark visited, dfs里会做
        dfs(grid, i, j, rows, cols);
      }
    }
  }
  return count;
}

final static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
private void dfs(char[][] grid, int x, int y, int rows, int cols) {
  // base case
  if(x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == '0') {
    return;
  }
  // recursive rule
  grid[x][y] = '0'; //首先mark成visited
  for(int[] dir : dirs) {
    int neiX = dir[0] + x;
    int neiY = dir[1] + y;
    dfs(grid, neiX, neiY, rows, cols);
  }
}

public static class Pair {
  int x;
  int y;
  Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
private void bfs(char[][] grid, int x, int y, int rows, int cols) {
  Queue<Pair> queue = new ArrayDeque<>();
  queue.offer(new Pair(x, y));
  while(!queue.isEmpty()) {
    Pair curr = queue.poll();
    for(int[] dir : dirs) {
      int neiX = dir[0] + x;
      int neiY = dir[1] + y;
      if(neiX >= 0 && neiX < rows && neiY >=0 && neiY < cols && grid[neiX][neiY] == '1') {
        grid[neiX][neiY] = '0';
        bfs(grid, neiX, neiY, rows, cols);
      }
    }
  }
}




