/*
minium split使1个数拆成几个完全平方数的和
eg: 10 = 3^2 + 1^2 -> return 2
4 = 2^2 -> return 1
我的思路：切，切完再check两边是不是平方数
optimize: 切的时候，小段只选哪些是平方数的切
*/

//切绳子，切单词，查字典
//assume input > 0
public int split(int num) {
  if(num <= 1) {
    return 1;
  }
  int[] m = new int[num+1];
  for(int i = 1; i <= num; i++) {
    m[i] = i;
    for(int j = 1; j*j <= i; j++) { //右小段，切多长，仅选择那些是平方数的来切，剩下的num-j 再check
      int tmp = m[i-j*j] + 1; //查表得到左大段需要最少切几次
      m[i] = Math.min(m[i], tmp);
    }
  }
  return m[num];
}


