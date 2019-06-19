//Determine a binary tree is a BST
/*
		10
	 / 	 \
  5			15
 / \		/ \
2   7  12  20
what is the BST: 
	for every single node, the left subtree is less than its value; the right subtree is larger than its value
	
method: recursion, send the corrent range from up to down, check whether the node value is in this range
base case: root == null -> true
subproblem: left subtree is BST && right subtree is BST
recursion rule: subproblem && left < this node < right

*/
/* 
Time = O(n);
Space = O(h).
*/

public boolean isBST(TreeNode root) {
	if(root == null) {
		return true;
	} 
	return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}
private boolean isBST(TreeNode root, int min, int max) {
	if(root == null) {
		return true;
	} 
	if(root.value <= min || root.value >= max) {
		return false;
	}
	return isBST(root.left, min, root.value) && isBST(root.right, root.value, max);
}
