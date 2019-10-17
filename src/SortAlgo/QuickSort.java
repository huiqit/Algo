// quick sort
class QuickSort {
 public void quickSort(int[] array) {
   if(array == null || array.length == 0) {
     return;
   }
   sort(array, 0, array.length - 1);
 }
 private void sort(int[] array, int left, int right) {
   if(left >= right) {
     return;
   }
   Random rand = new Random();
   int pivotIndex = left + rand.nextInt(right - left + 1);
   swap(array, pivotIndex, right);
   int i = left;
   int j = right - 1;
   while(i <= j) {
     if(array[i] < array[right]) {
       i++;
     } else {
       swap(array, i, j);
       j--;
     }
   }
   swap(array, right, i);
   sort(array, left, i-1);
   sort(array, i+1, right);
 }
}
