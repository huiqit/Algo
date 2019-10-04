/*
k pairs (),
m pairs <>,
n pairs {}.

*/

class Solution {
  public List<String> all(int k, int m, in n) {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    Deque<Character> stack = new ArrayDeque<>();
    helper(k, m, n, 0, 0, 0, sb, res, stack);
    return res;
  }
  private void helper(int k, int m, int n, int kLeft, int mLeft, int nLeft, StringBuilder sb, List<String> res, Deque<Character> stack) {
    if(k == kLeft && m == mLeft && n == nLeft) {
      res.add(sb.toString());
      return;
    }
    if(kLeft < k) {
      sb.append('(');
      stack.offerFirst('(');
      helper(k, m, n, kLeft+1, mLeft, nLeft, sb, res);
      sb.deleteCharAt(sb.length() - 1);
      stack.pollFirst();
    }
    // same as the other two
    if(stack.peek() != null && stack.peek() == '(') {
      sb.append(')');
      stack.pollFirst();
      helper(k, m, n, kLeft, mLeft, nLeft, sb, res, stack);
      sb.deleteCharAt(sb.length() - 1);
      stack.offerFirst('(');
    }
    //same as the other two
  }
}
      
