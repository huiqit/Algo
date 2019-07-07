/*
思路：要求最短距离，则把最短距离放进minHeap里。-> 无法return 坐标，而且有多个坐标的distance一样时，去重会去掉，这不是本意。
（不同的坐标，相同的距离，也应该保留。去重，去的是重复的坐标，最原始的，而不是加工过的距离。）
所以minHeap里放的应该是坐标，坐标值每次变化无规律，index是每次+1的，所以放index进去。
1. initial state: [x=0][y=0][z=0]
2. expand/generation rule: 
  expand state [i][j][k] -> generate [i+1][j][k]
                            generate [



*/
public class Solution {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    
