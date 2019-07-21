/* 
The idea is that:
1. get the depth of the two nodes, which is the length from root to the node
2. lift the lower one to the higher one, so they are in the same level.
3. list them together, and the first encounter node is their lca.
*/

class TreeNode {
  int value;
  TreeNode left;
  TreeNode right;
  TreeNode parent;
  TreeNode(int value) {
    this.value = value;
    this.parent = parent; // why only parent, not left or right?
  }
}

public TreeNode lca(TreeNode one, TreeNode two) {
  int l1 = length(one);
  int l2 = length(two);
  if(l1 < l2) {
    return lca(one, two, l2-l1);
  } else {
    return lca(two, one, l1-l2);
  } 
}
private int length(TreeNode root) {
  int length = 0;
  while(root != null) {
    length++;
    root = root.parent;
  }
  return length;
}
private TreeNode lca(TreeNode shorter, TreeNode longer, int diff) {
  while(diff > 0) {
    longer = longer.parent;
    diff--;
  }
  while(longer != shorter) {
    longer = longer.parent;
    shorter = shorter.parent;
  }
  return longer;
}
  
