!!!time complexity
面试要说全称：depth first search (breath)
if(set.add(array[i])) !!!!!!!!!!!!!!!!!!!!!!!!!

/*
#3 Given a string with duplicate letters, how to print out all permutations of the string. 
Assume the input is not null or "". E..g, input = “aab” → “aab”, “aba”, “baa”
*/

/*
DFS & HashSet
Assumption: input is not null or empty
*/
//n is the the number of letters
//Time = O(n!), permutations.
//Space = O(n), recursion & hashset
//print out, so return void
public void permutations(String input) {
  char[] array = input.toCharArray(); 
  permutations(array, 0);
}
private void permutations(char[] array, int index){
  if(index == array.length){
    System.out.println(new String(array));
    return;
  }
  //use a hashset to record which letter has been used
  HashSet<Character> set = new HashSet<>(); 
  for(int i = index; i < array.length; i++)  {
    if(!set.contains(array[i])){ //if(set.add(array[i]))
      set.add(array[i]);
      swap(array, index, i); 
      permutations(array, index + 1);
      swap(array, index, i);
    }
  }
}
private void swap(char[] array, int x, int y) {
  char tmp = array[x];
  array[x] = array[y];
  array[y] = tmp;
}



