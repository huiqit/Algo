/*
Everything of LCA
1. 基础版
1.1 without paraent pointer, follow up: 判断这两个node是否都在树里
1.2 with parent pointer
1.3 in bst 
2. n nodes in binary tree
3. 2 nodes in k-nary tree
4. m nodes in k-nary tree
*/

// 1.2 with parent pointer
/*
思路：
先get这两个node的深度（helper function)
然后merge（helper function): 
  先把低的拉平
  然后一起往上，直到相等
assume the two TreeNodes are not null -> 没意义嘛
⚠️注意：不能用long/short作为变量名！它们是关键字
*/
public class TreeNode{
  public int value;
  public TreeNode left;
  public TreeNode right;
  public TreeNode parent;
  public TreeNode(int value, TreeNode parent) {
    this.value = value;
    this.parent = parent;
  }
}
public TreeNode lca(TreeNode one, TreeNode two) {
  int depth1 = getDepth(one);
  int depth2 = getDepth(two);
  if(depth1 <= depth2) {
    return merge(one, two, depth2 - depth1);
  } else {
    return merge(two, one, depth1 - depth2);
  }
}
private int getDepth(TreeNode root) {
  int depth = 0;
  while(root != null) {
    depth++;
    root = root.parent;
  }
  return depth;
}
private TreeNode merge(TreeNode shorter, TreeNode longer, int diff) {
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
  
// 1.3 LCA in bst (leetcode 答案很好）
/*
在进入left/right recursion之前，先判断一下，剪枝
*/
public TreeNode lca(TreeNode root, int p, int q) {
  if(root.value > p && root.value > q) {
    return lca(root.left, p, q);
  } else {
    return lca(root.right, p, q);
  }
  return root;  //说明此时卡住了（root.value在p, q之间）且是第一个卡住的（从下往上第一个），所以是lca
}
  
  
  
  
  
  
  
  
  
  
  
  




