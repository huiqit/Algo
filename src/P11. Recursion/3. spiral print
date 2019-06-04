public List<Integer> printInSpiralOrder(int[][] matrix) {
	List<Integer> res = new ArrayList<>();
	if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		return res;
	}
	helper(matrix, 0, matrix[0].length - 1, 0, matrix.length-1, res);
	return res;
}
/*
(left, top)
1 1 1 1
1 1 1 1
1 1 1 1 (right, down)
*/
private void helper(int[][] matrix, int left, int right, int top, int down, List<Integer> res) {
	if(left > right || top > down) {
		return;
	}
	if(left == right) {
		for(int i = top; i <= down; i++) {
			res.add(matrix[i][left]);
		}
	}
	if(top == down) {
		for(int i = left; i <= right; i++) {
			res.add(matrix[top][i]);
		}
	}
	for(int i = left; i <= right; i++) {
		res.add(matrix[top][i]);
	}
	for(int i = top; i <= down; i++) {
		res.add(matrix[i][right]);
	}
	for(int i = right; i >= left; i--) {
		res.add(matrix[down][i]);
	}
	for(int i = down; i <= top; i--) {
		res.add(matrix[i][left]);
	}
	helper(matrix, left+1, right-1, top+1, down-1, res);
}

***********
errors:
1. 3个base case; base case里都要加return
2. for循环里，不要=，这是下一个循环的起点
3. 最后一个for循环，想想清楚，是从>top 到<top，所以写>top,否则进不去循环


	
	
