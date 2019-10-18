/*
follow up
1. check valid in O(1)
2. obstacle 
   分成subrows
*/

class NQueens {
	public int nQueens(int n) {
		int[] res = new int[]{0};
		int[] A = new int[n];
		helper(n, 0, A, res);
		return res[0];
	}
	private void helper(int n, int level, int[] A, int[] res) {
		if(n == level) {
			res[0]++;
			return;
		}
		for(int i = 0; i < n; i++) {
			A[level] = i;
			if(valid(A, level)) {
				helper(n, level+1, A, res);
			}
		}
	}
	private boolean valid(int[] A, int level) {
		for(int i = 0; i < level; i++) {
			if(A[i] == A[level] || Math.abs(A[level] - A[i]) == Math.abs(level - i)) {
				return false;
			}
		}
		return true;
	}
}
	
	

***********************************************************
public List<List<Integer>> nQueens(int n) {
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> curr = new ArrayList<>();
	nQueens(n, res, curr);
	return res;
}
private void nQueens(int n, List<List<Integer>> res, List<Integer> curr) {
	if(curr.size() == n) {
		res.add(new ArrayList<Integer>(curr));
		return;
	}
	//i is the rows number, from 0 to n-1 -> 不必，base case可以天然的handle
	//recursion只需考虑当前层，不要写for(int i = 0; i < n; i++) {
	//j is the column index
	for(int j = 0; j < n; j++) {
		if(valid(curr, j) {
			curr.add(j);
			nQueens(n, res, curr);
			curr.remove(curr.size() - 1);
		}
	}
}
private boolean valid(List<Integer> curr, int col) {
	int curr_row = curr.size();
	for(int i = 0; i < curr_row; i++) {
		//if(curr[i] == col) {
		if(curr.get(i) == col) {
			return false;
		}
		if(Math.abs(curr.get(i) - col) == Math.abs(curr_row - i)) {
			return false;
		}
	}
	return true;
}

***********************************************************
O(1) check valid: boolean[]
public List<List<Integer>> nqueens(int n) {
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> curr = new ArrayList<>();
	boolean[] col = new boolean[n];
	boolean[] dia = new boolean[2*n - 1];
	boolean[] revDia = new boolean[2*n-1];
	nqueens(n, res, curr, col, dia, revDia);
	return res;
}
private void nqueens(int n, List<List<Integer>> res, List<Integer> curr, boolean[] col, boolean[] dia, boolean[] revDia) {
	if(n == curr.size()) {
		res.add(new ArrayList<Integer>(curr));
		return;
	}
	for(int j = 0; j < n; j++) {
		if(valid(j, n, curr, col, dia, revDia)) {
			curr.add(j);
			mark(j, n, col, dia, revDia);
			nqueens(n, res, curr, col, dia, revDia);
			curr.remove(curr.size() - 1);
			unmark(j, n, col, dia, revDia);
		}
	}
}
private boolean valid(int j, int n, List<Integer> curr, boolean[] col, boolean[] dia, boolean[] revDia) {
	int row = curr.size();
	return !col[j] && !dia[j+row] && !revDia[j-row+n-1];
}
private void mark(int j, int n, List<Integer> curr, boolean[] col, boolean[] dia, boolean[] revDia) {
	int row = curr.size()-1;
	col[j] = true;
	dia[j+row] = true;
	revDia[j-row+n-1] = true;
}
private void unmark(int j, int n, List<Integer> curr, boolean[] col, boolean[] dia, boolean[] revDia) {
	int row = curr.size();
	col[j] = false;
	dia[j+row] = false;
	revDia[j-row+n-1] = false;
}
	
***********************************************************
O(1) check valid: hashSet
public List<List<Integer>> nqueens(int n) {
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> curr = new ArrayList<>();
	Set<Integer> col = new HashSet<>();
	Set<Integer> dia = new HashSet<>();
	Set<Integer> revDia = new HashSet<>();
	nqueens(n, res, curr, col, dia, revDia);
	return res;
}
private void nqueens(int n, List<List<Integer>> res, List<Integer> curr, Set<Integer> col, Set<Integer> dia, Set<Integer> revDia) {
	if(curr.size() == n) {
		res.add(new ArrayList<Integer>(curr));
		return;
	}
	for(int j = 0; j < n; j++) {
		if(valid(j, curr, col, dia, revDia)) {
			curr.add(j);
			mark(j, curr, col, dia, revDia);
			nqueens(n, res, curr, col, dia, revDia);
			curr.remove(curr.size() - 1);
			unmark(j, curr, col, dia, revDia);
		}
	}
}
private boolean valid(int j, List<Integer> curr, Set<Integer> col, Set<Integer> dia, Set<Integer> revDia) {
	int row = curr.size();
	return !col.contains(j) && !dia.contains(j+row) && !revDia.contains(j-row);
}
private void mark(int j, List<Integer> curr, Set<Integer> col, Set<Integer> dia, Set<Integer> revDia) {
	int row = curr.size()-1;
	col.add(j);
	dia.add(j+row);
	revDia.add(j-row);
}
private void unmark(int j, List<Integer> curr, Set<Integer> col, Set<Integer> dia, Set<Integer> revDia) {
	int row = curr.size();
	col.remove(j);
	dia.remove(j+row);
	revDia.remove(j-row);
}
***********************************************************
注意：mark的时候row = size - 1


