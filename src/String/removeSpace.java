/*
Char removal 
use a slow and a fast pointer to do it
[0, i): processed
[i, j): we don't care
[j, n-1]: explore area
copy:
1. letters
2. first space & not leading -> i == 0
*/
//Time = O(n), two pointers go through this array
//Space = O(1), if we don't care the new String
public String remove(String input) {
  if(input == null || input.length() <= 1) {
    return input;
  }
  char[] array = input.toCharArray();
  int i = 0;
  int j = 0;
  while(j < array.length) {
    if(array[j] == ' ' && (i == 0 || array[j-1] == ' ')){
      j++;
    } else {
      array[i++] = array[j++];
    }
  }
  //post process: trailing
  if(i > 1 && array[i-1] == ' ') { //i > 1在干嘛啊，> 0 就行
    return new String(array, 0, i-1);
  } else {
    return new String(array, 0, i);
  }
}


