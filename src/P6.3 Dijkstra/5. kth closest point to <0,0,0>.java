/*
思路：要求最短距离，则把最短距离放进minHeap里。-> 无法return 坐标，而且有多个坐标的distance一样时，去重会去掉，这不是本意。
（不同的坐标，相同的距离，也应该保留。去重，去的是重复的坐标，最原始的，而不是加工过的距离。）
重复的元素不会影响正确性，只会影响efficiency.
所以minHeap里放的应该是坐标，坐标值每次变化无规律，index是每次+1的，所以放index进去。
1. initial state: [x=0][y=0][z=0]
2. expand/generation rule: 
  expand state [i][j][k] -> generate [i+1][j][k]
                            generate [i][j+1][k]
                            generate [i][j][k+1]
3. Termination condition: while(k>1), k--, minHeap.peek() is what we need
写>0 或者>1都行，因为一般curr只在while循环内定义，出了循环就拿不到了，所以写>1，minHeap的peek()则为答案。
这里curr在外面定义的，所以>0 然后直接curr的就是要找的那个
minHeap里要能够按照distance排序，这样才能generate出来最cloest的那个。
单一功能原则 -> 单独一个method算distance
*/
/*
这题与上一题的不同之处在于，不能通过简单的变换，由d1->d2。上一题只需要简单的*5或*7就能变换到下一个要求的值。
既然没有这个规律，那就只能老老实实的。所以offer进去每个array的index是更有效的，因为每次变动的是index，单独的一个method计算distance,
每次index+1，这是固定的，注意check index out of bound，然后看下当前的distance是否已经在set里（去重，去的是distance）
但是，set里不能放distance！！！你要把所有点都放进去，如果第1个点和第2个点的distance相同，但是去掉了第2个点的话，就把第2个点所有的邻居，以及邻居的邻居，都去掉了。。
一般来说，minHeap里要和set里放的东西保持一致。
真的会有点被generate出来2次：a2b2 <- a2b1, a1b2。所以需要set去重，去的是这种！傻傻的去就行了。
*/

public class Solution {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    //define a minHeap that can poll the shortest distance
		PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> point1, List<Integer> point2) {
        long d1 = distance(point1, a, b, c);
        long d2 = distance(point2, a, b, c);
        if(d1 == d2) {
          return 0;
        } 
        return d1 < d2 ? -1 : 1;
			}
    });
		
	  //use a hashset to deduplicate the same point
	  Set<List<Integer>> set = new HashSet<>();
    //initial state
		List<Integer> curr = Arrays.asList(0, 0, 0); 
		minHeap.offer(curr);
		set.add(curr);
		while(k > 0) { 
			curr = minHeap.poll();
			List<Integer> next = Arrays.asList(curr.get(0) + 1, curr.get(1), curr.get(2));
			if(curr.get(0) + 1 < a.length && set.add(next)) {
				minHeap.offer(next);
			}
			
			next = Arrays.asList(curr.get(0), curr.get(1) + 1, curr.get(2));
			if(curr.get(1) + 1 < b.length && set.add(next)) {
				minHeap.offer(next);
			}
			
			next = Arrays.asList<curr.get(0), curr.get(1), curr.get(2) + 1);
			if(curr.get(2) + 1 < c.length && set.add(next)) {
				minHeap.offer(next);
			}
			k--;
		}
	}
	
	private long distance(List<Integer> point, int[] a, int[] b, int[] c) {
		long dis = 0;
		dis += a[point.get(0)] * a[point.get(0)];
		dis += b[point.get(1)] * b[point.get(1)];
		dis += c[point.get(2)] * c[point.get(2)];
		return dis;
	}
}


			
			
			
			
			
			
			
