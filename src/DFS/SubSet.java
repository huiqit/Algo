/* 
find all subset of a string. return a list of string.
eg: "abc" -> {"", "a", "b", "c", "ab", "bc", "ac", "abc"}
"" -> [""]
null -> []
*/
/* recursion tree:
level 0: empty                    {}
level 1: for a,       +a {a}         not +a {}
level 2: for b,     {ab}      {a}       {b}     {}
level 3: for c, {abc} {ab} {ac} {a}  {bc} {b} {c} {}
*/
/*
Notice： stringBuilder append, no remove API. use deleteCharAt()
*/
public List<String> subSets(String input) {
  List<String> res = new ArrayList<>();
  if(input == null) {
    return res;
  }
  if(input.length == 0) {
    res.add("");
    return res;
  }
  char[] array = input.toCharArray();
  StringBuilder curr = new StringBuilder();
  subSets(array, res, curr, 0);
  return res;
}
private void subSets(char[] input, List<String> res, StringBuilder curr, int level) {
  if(level == input.length) {
    res.add(new ArrayList<>(curr);
    return;
  }
  curr.append(input[level]);
  subSets(input, res, curr, level+1);
  curr.deleteCharAt(curr.size() - 1);
  subSets(input, res, curr, level+1);
}
  
