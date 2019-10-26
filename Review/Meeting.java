/*
arrive time: [1, 2, 2, 3, 4]
departure time: [2, 2, 3, 4, 4]
5 people, 4days

感觉类似8皇后问题，
第一天，选择可以meeting的人，for loop一下，mark visited，然后第二天，可以meeting的人，。..直到最后一天

*/
public int meeting(int[] arrival, int[] departure) {
  int n = 0; //天数 1～n
  for(int d : departure) {
    n = Math.max(n, d);
  }
  int[] res = {0}; //返回最多meet几个人
  Map<Integer, List<Integer>> map = new HashMap<>();
  /*
  // 用map记录每个人 - 可以meet的day
  for(int i = 0; i < arrival.length; i++) {
    int start = arrival[i];
    int end = departure[i];
    List<Integer> days = new ArrayList<>();
    for(int d = start; d <= end; d++) {
      days.add(d);
    }
    map.put(i, days);
  }
  */
  
  // 用map记录每天 - 可以meeting的人
  for(int i = 1; i <= n; i++) {
    List<Integer> res = new ArrayList<>();
    for(int num = 0; num < arrival.length; num++) {
      if(arrival[num] >= i && departure[num] <= i) {
        res.add(num);
      }
    }
    map.put(i, res);
  }
  
  boolean[] visited = new boolean[arrival.length]; //记录哪些人被visited过了
  helper(n, 1, res, 0, map, visited);
  return res[0];
}
// n: days
// index: on which day 1~n 
private void helper(int n, int index, int[] res, int curr, Map<Integer, List<Integer>> map, boolean[] visited) {
  if(index == n+1) {
    res[0] = Math.max(res[0], curr);
  }
  // 当前层只处理今天可能见的人
  List<Integer> todayMeet = map.get(index); // map: index 第几天 1~n - meet 哪些人 0~arrival.length-1
  for(int people : todayMeet) {
    if(!visited[people]) {
      visited[people] = true;
      curr++;
      helper(n, index+1, res, curr, map, visited);
      visited[people] = false;
      curr--;
    }
  }
}
    
    
  
  
  
