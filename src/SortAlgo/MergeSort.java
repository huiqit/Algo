// Time = O(nlogn)
// Space = O(n)
public class MergeSort {
  public void mergeSort(int[] array) {
    if(array == null || array.length == 0) {
      return;
    }
    int[] helper = new int[array.length];
    sort(array, helper, 0, array.length-1);
  }
  private void sort(int[] array, int[] helper, int left, int right) {
    if(left == right) {
      return;
    }
    int mid = left + (right - left)/2;
    sort(array, helper, left, mid);
    sort(array, helper, mid+1, right);
    
    for(int i = left; i <= right; i++) {
      helper[i] = array[i];
    }
    int i = left;
    int j = mid+1;
    int k = left;
    while(i <= mid && j <= right) {
      if(helper[i] < helper[j]) {
        array[k++] = helper[i++];
      } else {
        array[k++] = helper[j++];
      }
    }
    while(i <= mid) {
      array[k++] = helper[i++];
    }
  }
}

