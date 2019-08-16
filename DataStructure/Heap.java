
public class MinHeap {
  private int[] array;
  private int size;
  
  MinHeap(int[] array) {
    if(array == null || array.length == 0) {
      throw new IllegalArgumentException("input array cannot be null or empty");
    }
    this.array = array;
    size = array.length;
    heapify();
  }
  
  private void heapify() {
    for(int i = (size-1)/2; i >= 0; i--) {
      percolateDown(i);
    }
  }
  
  private void percolateUp(int index) {
    while(index >= 0) {
      int parentIndex = (index-1)/2;
      if(array[index] < array[parentIndex]) { //不需要check parentIndex >= 0 && 
        swap(array, index, parentIndex);
      } else {
        break;  //!!
      }
      index = parentIndex;
    }
  }
  
  private void percolateDown(int index) {
    //往下看，只要有孩子，就和孩子比较一下
    //有2个孩子的话选个小的
    //有1个孩子那只能是左孩子了，所以先把candidate设为左孩子
    //然后再比较candiate和自己谁小，swap or break
    while(index <= (size-1)/2) {
      int leftChildIndex = index*2+1;
      int rightChildIndex = index*2+2;
      int candidate = leftChildIndex; // 如果有1个孩子，那必定是左孩子。右孩子需要check bound。array[leftChildIndex] > array[rightChildIndex] ? rightChildIndex : leftChildIndex;
      if(rightChildIndex <= size && array[rightChildIndex] < array[leftChildIndex]) {
        candidate = rightChildIndex;
      }
      
      if(array[index] < array[candidate]) {
        swap(array, index, candidate);
      } else {
        break;
      }
      index = candidate;
    }
  }
  
  private int update(int index, int ele) {
    //check index out of bound
    int oldEle = array[index];
    array[index] = ele;
    if(ele < oldEle) {
      percolateUp(index);
    } else {
      percolateDown(index);
    }
    return oldEle;
  }
  
  public void offer(int ele) {
    if(size == array.length) {
      int[] newArray = new int[size*1.5];
      copy(array, newArray);
    }
    array[size] = ele;
    size++;
    percolateUp(size-1);
  }
  
  public int poll(){
    int res = array[0];
    array[0] = array[size-1];
    size--;
    percolateDown(0);
    return res;
  }
  
}


