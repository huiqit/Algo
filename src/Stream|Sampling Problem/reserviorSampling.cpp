class Solution {
  vector<int> reserviorSampling(vector<int> input, int k) {
    vector<int> res;
    srand(time(NULL)); 
    for(int i = 0; i < k; i++) {
      res.push_back(input[i]);
    }
    for(int i = k; i < input.size(); i++) {
      int candidate = rand() % i;
      if(i < k) {
        res[i] = input[i];
      }
    }
    return res;
  }
}
