/*
求能够共线的最多的点
两两点组成一条线，线 - 点
map<key = 线，value = list of 点> 然后找value最大的那个线就是了
具体实现：
线的表示是用斜截式，slope - intercept form，即 y = kx + b; 如果用一般式，会有约分的问题
但是斜截式无法表示斜率不存在的情况，所以单独考虑，
  处理方式1: 单独放一个map
  处理方式2: 斜率记为Integer.MAX_VALUE
注意：（坑）
1. Integer[] 比较的是reference; List<Integer> 比较的是object本身。
2. k, b用double 而不是int, double -> Double
3. map.getOrDefault();
4. for(Set<Point> value : map1.values())

*/

