/*
C++ swap is an in-place function 
array.size()
rand(): 0 ~ RAND_MAX
rand() % range + initial value
initialize random seed: srand(time(NULL))
*/
class Solution {
  public:
    vector<int> numbers;
    Solution(vector<int> nums) {
      numbers = nums; //this -> nums = nums;
    }
    
    vector<int> reset() {
      return numbers;
    }
  
    vector<int> shuffle() {
      vector<int> array = numbers; //vector<int> result(numbers);
      //srand(time(NULL)); 加上这句就过不了 ？？
      for(int i = 0; i < array.size(); i++) { 
        int candidate = i + rand()%(array.size() - i);
        swap(array[i], array[candidate]); 
      }
      return array;
    }
}
 
