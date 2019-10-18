
class GetHeight {
  public int getHeight(TreeNode root) {
    if(root == null) {
      return 0;
    } 
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    return left+right+1;
  }
}
