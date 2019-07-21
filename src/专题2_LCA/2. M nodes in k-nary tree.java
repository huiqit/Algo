/* 
2. k nodes in binary tree
3. 2 nodes in k-nary tree
4. m nodes in k-nary tree
list/set both have contains API
*/
// 2. k nodes in binary tree, just change <one, two> to List<TreeNode>
public TreeNode lca(TreeNode root, List<TreeNode> list) {
  if(root == null || list.contains(root)) {
    return root;
  }
  TreeNode left = lca(root.left, list);
  TreeNode right = lca(root.right, list);
  if(left != null && right != null) {
    return root;
  }
  return (left != null) ? left : right;
  
// 3. two nodes in k-nary tree
class TreeNode {
  public int value;
  public TreeNode left;
  public TreeNode right;
  public List<TreeNode> children;
  public TreeNode(int value) {
    this.value = value;
    children = new ArrayList<>();
  }
}
public TreeNode lca(TreeNode root, TreeNode one, TreeNode two) {
  if(root == null || root == one || root == two) {
    return root;
  }
  TreeNode tmp = null;
  int counter = 0;
  for(TreeNode child : children) {
    TreeNode node = lca(root.child, one, two);
    if(node != null) {
      counter++;
      tmp = node;
    }
    if(counter == 2) {
      return root;
    }
  }
  return tmp;
}

//Q4. m nodes in k-nary tree
public TreeNode lca(TreeNode root, List<TreeNode> list) {
  if(root == null || list.contains(root)) {
    return root;
  }
  int counter = 0;
  TreeNode tmp = null;
  for(TreeNode child : children) {
    TreeNode node = lca(root.child, list);
    if(node != null) {
      counter++;
      tmp = node;
    }
    if(counter > 1) { //if got more than 1 node, return the current one, and report to the parent, so on
      return root;
    }
  }
  return tmp;
}


  
  
  
  
  
  
