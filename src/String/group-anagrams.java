/*
给一个String[]，把是anagram的那些string放在一起，最后返回List<List<String>>
思路：把每个string 转 char array,排个序！然后再转成string，anagram们就能是一样的了，放map里。
*/
class Solution {
  public List<List<String>> groupAna(String[] input) {
    if(input == null || input.length == 0) {
      return new ArrayList<List<String>>();
    }
    Map<String, List<String>> map = new HashMap<>();
    for(String s : input) {
      char[] sArray = s.toCharArray();
      Arrays.sort(sArray);
      String newS = new String(sArray);
      List<String> currList = map.getOrDefault(newS, new ArrayList<>());
      currList.add(s);
      map.put(newS, currList);
    }
    return new ArrayList<List<String>>(map.values());
  }
}

