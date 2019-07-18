/*
各种方法都能做出来的！
*/
/*
方法1: 三步曲，从下往上返值，lca
问left/right要的值：left/right的level 层数；如果没找到，那就返回-1
当前值做什么事：判断一下
report to parent: level or -1
*/
public boolean isCousin(TreeNode root, TreeNode one, TreeNode two) {
  return getHeight(root, one two) > 0;
}
private int getHeight(TreeNode root, TreeNode one, TreeNode two, int level) {
  if(root == null) {
    return -1;
  }
  //这里返回的是one/two 的level
  if(root == one || root == two) {
    return level; 
  }
  int left = getHeight(root.left, one, two, level+1); //拿到one or two的level
  int right = getHeight(root.right, one, two, level+1);
  
  //只有当它们都不是-1的时候，现在这个点才是lca（从下往上返值），此level非彼level，这里的level是lca的level
  if(left != -1 && right != -1) {
    if(left == right && left - level > 1) {
      return 1;
    } else {
      return -1;
    }
  }
  return left == -1 ? right : left;
}

/*
方法二：
dfs + 是否有lca，基本的recursion ?
*/

/*
方法三：
判断2个node是否在同一个level：bfs
一层一层的遍历这个tree
*/

