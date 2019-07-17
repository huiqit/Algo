/*
#1
Given a string, we can insert at most one empty space between each pair of adjacent letters. 
n层数，每层2种情况：加空格 or 不加空格
*/

public void permutations(String input) {
  StringBuilder sb = new StringBuilder();
  helper(input, sb, 0);
}
private void helper(String input, StringBuilder sb, int index) {
  if(index == input.length() - 1) {
    sb.append(input.charAt(index));
    System.out.println(sb.toString());
    sb.deleteCharAt(sb.length() - 1); //别忘了删！！！！！！！！！！！
    return;
  }
  sb.append(input.charAt(index));
  helper(input, sb, index+1);
  sb.deleteCharAt(sb.length() - 1);
  
  sb.append(input.charAt(index) + "_");
  helper(input, sb, index+1);
  sb.deleteCharAt(sb.length() - 1);
  sb.deleteCharAt(sb.length() - 1);
}
      
