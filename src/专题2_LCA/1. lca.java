/*
Q1. if only one node in the tree, return this one.
  case1: if one is under the other one, just find the upper one and can return
	case2: if the two nodes are not "belong to" relationship, we get node from left and right, so we return the current node. 
	The lowest nodes is the first one that got left != null && right != null. since we send value from down to up.
	
Q2. if only one node in the tree, return null. (add a helper function to judge if another node in the tree)
  when we get the lca node is one of the two, we need to add addition judge step:
	see the return node as root, and use lca to find another one in its subtree. 
	if find it, it's fine, the result doesn't change, also return the previous upper one.
	if not, that indicates the other one doesn't exist in the tree, return null.
*/
//Q1.
public TreeNode lca(TreeNode root, TreeNode one, TreeNode two) {
  if(root == null || root == one || root == two) {
	  return root;
	}
	TreeNode left = lca(root.left, one, two);
	TreeNode right = lca(root.right, one, two);
	if(left != null && right != null) {
	  return root;
  }
	return (left != null) ? left : right;
}
//Q2.
public TreeNode lca2(TreeNode root, TreeNode one, TreeNode two) {
  TreeNode node = lca(root, one, two);
	if(node == one) {
	  if(lca(one, two, two) == null) {
		  return null;
	  }
	}
	if(node == two) {
	  if(lca(two, one, one) == null) {
		  return null;
		}
	}
	return node;
}

