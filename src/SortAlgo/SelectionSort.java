/*
1. selection sort
2. sort a stack, by using additional 2/1 stack(s)

*/

public class SelectionSort {
  public void selectionSort(int[] array) {
    if(array == null || array.length == 0) {
      return;
    }
    for(int i = 0; i < array.length; i++) {
      int minIndex = i;
      for(int j = i+1; j < array.length; j++) {
        if(array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      swap(array, minIndex, i); // !
    }
  }
  private void swap(int[] array, int x, int y) {
    int tmp = array[x];
    array[x] = array[y];
    array[y] = tmp;
  }
  
  // from top to bottom, ascending
  // stack: 2 7 5 1 9 7 8
  // output: bottom 9 8 7 7 5 2 1 top ->
  public void sortStack(Deque<Integer> stack) {
    // check
    if(stack.isEmpty()) {
      return;
    }
    Deque<Integer> helper = new LinkedList<>();
    sort(stack, helper);
  } 
  private void sort(Deque<Integer> stack, Deque<Integer> buffer) {
    for(int i = 0; i < stack.size(); i++) {
      int minNum = stack.peekFirst();
      while(!stack.isEmpty()) {
        int tmp = stack.pollFirst();
        minNum = Math.min(tmp, minNum);
        buffer.offerFirst(tmp);
      }
      while(!buffer.isEmpty() && buffer.peekFirst() >= minNum) {
        int tmp = buffer.pollFirst();
        if(tmp != minNum) {
          stack.offerFirst(tmp);
        }
        buffer.offerFirst(tmp);
      }
    }
    while(!buffer.isEmpty()) {
      stack.offerFirst(buffer.pollFirst());
    }
  }
    
      
}


