/*
#4 Given an array of strings, find if all the strings can be chained to form a circle. 
思路：all permutations, 在permu的时候选择string加限制，提前剪枝
*/
// assume input is not null or empty
public boolean canChain(String[] array) {
  return permutations(array, 1);
}

private boolean permutations(String[] array, int index) {
  if(index == array.length) {
    return canConnect(array[array.length-1], array[0])) { //前一个string的尾巴，和后一个string的头
  }
  //["aba", "abb", "baa"]
  for(int i = index; i < array.length; i++) {
    //如果前一个string的最后一个char，和将要pick的这个string的第一个char一样，那就选;
    //如果进不去if，那就下一个i就好了；所有的都进不去，return false
    if(canConnect(array[index-1], array[i])) {
      swap(array, index, i);
      if(permutations(array, index+1)) {
        return true;
      }
      swap(array, index, i);
    }
  }
  return false;
}
  
  //前一个string的尾巴，和后一个string的头
private boolean canConnect(String word1, String word2) {
  return word1.charAt(word1.length()-1) == word2.charAt(0);
}

private void swap(String[] array, int x, int y) {
  String tmp = array[x];
  array[x] = array[y];
  array[y] = tmp;
}

