// 438 https://leetcode.com/problems/find-all-anagrams-in-a-string/
/*
题意：在string s里找string p的所有anagram
例子：
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]
*/
/*
sliding window
hashMap
number of matches
*/
class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    if(s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) {
      return res;
    }
    // anagram map: p
    Map<Character, Integer> map = new HashMap<>();
    char[] pArray = p.toCharArray();
    for(char ch : pArray) {
      Integer count = map.get(ch);
      if(count == null) {
        map.put(ch, 1);
      } else {
        map.put(ch, count+1);
      }
    }
    
    int match = 0;
    // for loop the string s, expend right and remove left
    for(int i = 0; i < s.length(); i++) {
      // right: add new element
      char curr = s.charAt(i);
      Integer count = map.get(curr);
      if(count != null) {
        map.put(curr, count - 1);
        if(count - 1 == 0) {
          match++;
        } 
        if(count == 0) {
          match--;
        }
      }
      
      // left: remove old element
      // boundary check!!
      if(i >= p.length()) {
        char left = s.charAt(i - p.length());
        count = map.get(left);
        if(count != null) {
          map.put(left, count+1);
          if(count + 1 == 0) {
            match++;
          }
          if(count == 0) {
            match--;
          }
        }
      }
      
      // check if all matches
      if(match == map.size()) {
        res.add(i - p.length() + 1);
      }
    }
    return res;
  }
}
    
    
    
    
    
    
    
    
