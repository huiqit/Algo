import java.util.Random;

public class Solution {
  private int[] nums;
  private Random rand;
  
  public Solution(int[] nums) {
    this.nums = nums;
    rand = new Random();
  }
  
  public int[] reset() {
    return nums;
  }
  
  public int[] shuffle() {
    if(nums == null) {
      return null;
    }
    int[] array = nums.clone();
    for(int i = 0; i < array.length; i++) {
      int candidate = i + rand.nextInt(array.length - i);
      swap(array, candidate, i);
    }
  }
  
  private void swap(int[] array, int x, int y) {
    int tmp = array[x];
    array[x] = array[y];
    array[y] = tmp;
  }
}

