// unlimited times, return profit and which day to buy and sell
/*
参考：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/208241/Explanation-for-the-dummy-like-me.
其实我就差一步。。if改成while。。唉。。
其实我们就是在input array里找局部递增序列来交易，一旦有断崖，就卖出，然后低点再买入
所以：1. current value <= prev value时，比如8 4 2 1，更新buyIndex，在更min买入
      2. current value > prev value时，比如1 3 5，更新sellIndex，在更max卖出
两个case用while loop！！来找到当前序列的极值。

*/
public List<int[]> profit(int[] array) {
  List<int[]> res = new ArrayList<>();
  int buyIndex = 0;
  int sellIndex = 0;
  int profit = 0;
  int i = 1;
  
  while(i < array.length) {
    while(i < array.length && array[i] <= array[i-1]) {
      i++;
    }
    buyIndex = i;
    while(i < array.length && array[i] > array[i-1]) {
      i++;
    }
    sellIndex = i;
    
    profit += array[sellIndex] - array[buyIndex];
    res.add(new int[]{sellIndex, buyIndex});
  }
  return res;
}
