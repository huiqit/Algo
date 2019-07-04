/*
input: given a list of coins, from {25, 10, 5, 2, 1}, to get the target number
return: a list of list. 
eg: 
coins = {2, 1}, target = 4, the return should be
[
  [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)
  [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)
  [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)
]
eg: 99cents, [25,10,5,1]
                          99
          /            |        |       \
25       0             1        2        3      count = 99%25 = 3
remain   99           74       49       24      remain = target - factor * count
      /|||||\      /|||||\    /|||\     /|\
10   0123456789    01234567   01234     012
   /|||||\
5 012...5*19(95)
  /||||||\
1 99*1 

Time = 99^4（粗略，别较真）-> 99*20*10*4
*/

//coins=[25,10,5,1], coins.length = 4

public List<List<Integer>> combinations(int[] coins, int target) {
  List<List<Integer>> res = new ArrayList<>();
  if(coins == null || coins.length == 0) {
    return res;
  }
  List<Integer> curr = new ArrayList<>();
  combinations(coins, target, res, curr, 0);
  return res;
}
private void combinations(int[] coins, int target, List<List<Integer>> res, List<Integer> curr, int index) {
  if(index == coins.length-1) {
    if(target % coins[index] == 0) {
      curr.add(target/coins[index]);
      res.add(new ArrayList<>(curr));
      
    }
    return;//return必须在外面
  }
  
  int count = target / coins[index];
  for(int i = 0; i <= count; i++) {
    curr.add(i);
    int remain = target - i*coins[index];
    combinations(coins, remain, res, curr, index+1);
    curr.remove(curr.size()-1);
    combinations(coins, target, res, curr, index+1);
  }
}
  
//不提前一层返回
private void combinations(int[] coins, int target, List<List<Integer>> res, List<Integer> curr, int index) {
  if(index == coins.length) {
    if(target == 0) {
      res.add(new ArrayList<>(curr));      
    }
    return;
  }
  
  int count = target / coins[index];
  for(int i = 0; i <= count; i++) {
    curr.add(i);
    int remain = target - i*coins[index];
    combinations(coins, remain, res, curr, index+1);
    curr.remove(curr.size()-1);
    //combinations(coins, target, res, curr, index+1); 有for循环就不用再跑一遍递归了
  }
}













