/*
12 = 
6*2
4*3
2*2*3

            12
        /        \
6      0          1
      /  \         |
4    0    1         0
    /|\   /\        |
3  0 1 2  0 1       0
   |
2  

*/



public List<List<Integer>> combinations(int target) {
  List<List<Integer>> res = new ArrayList<>();
  if(target <= 3) {
    return res;
  }
  List<Integer> curr = new ArrayList<>();
  combinations(target, 2, res, curr);
  return res;
}
private void combinations(int target, int factor, List<List<Integer>> res, List<Integer> curr) {
  if(target == 1) {
		if(curr.size() > 0) {
			res.add(new ArrayList<>(curr));
		}
  }
  for(int i = factor; i <= target; i++) {
		if(target % i == 0) {
			curr.add(i);
			combinations(target/i, i, res, curr);
			curr.remove(curr.size() - 1);
		}
	}
}




******************************************************
public List<List<Integer>> combinations(int target) {
  List<List<Integer>> res = new ArrayList<>();
  if(target < 2) {
    return res;
  }
  List<Integer> curr = new ArrayList<>();
  int[] factors = getFactors(target).toArray();
  combinations(target, factors, res, curr, 0);
  return res;
}
private List<Integer> getFactors(int target) {
  List<Integer> res = new ArrayList<>();
  for(int i = 2; i < target/2; i++) {
    if(target%i == 0) {
      res.add(i);
    }
  }
  return res;
}
      
private void combinations(int target, int[] factors, List<List<Integer>> res, List<Integer> curr, int index) {
  if(index == factors.length) {
    if(target == 0) {
      res.add(new ArrayList<>(curr));
    }
    return;
  }
  int count = getCount(target, factors[index]);
  for(int i = 0; i <= count; i++) {
    curr.add(i);
    while(i > 0) {
      remain = target/factors[index];
      i--;
    }
    combinations(remain, factors, res, curr, index+1);
    curr.remove(curr.size() - 1);
  }
}  
private int getCount(int target, int factor) {
  int res = 0;
  while(target > factor) {
    target /= factor;
    res++;
  }
  return res;
}
  
  
  
  
  
  
