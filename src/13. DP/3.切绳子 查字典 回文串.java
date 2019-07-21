/* 3题都已test过
1. 切绳子问题
2. 查字典问题 #99
3. 回文串min cut #
*/
// Q1. Max product when cutting rope
/*
at least one cut must be made
n -> m, both integers
*/
/*
eg: 
_ M[1] = 0/invalid
_ | _ M[2] = 1 * 1 = max(1, M[1]) * 1
_ _ | _ M[3] = max(2, M[2]) * 1
_ | _ _ M[3] = max(1, M[1]) * 2
_ _ _ | _ M[4] = max(3, M[3]) * 1 | max(2, M[2]) * 2 | max(1, M[1]) * 3
_ _ _ _ | _ M[5] = max(4, M[4]) * 1 | max(3, M[3]) * 2 | max(2, M[2]) * 3 | max(1, M[1]) * 4

M[i] represents the max product for length i. 
so here, everytime we only consider about 1 cut, and look for the previous m[] to get the other cuts.
also, don't forget that you can no cuts there. so j starts from 0. no, you cannot. if j set to 0, then you need to find m[i], but you don't have it yet.
no cut means: for left side, you can use M[i] or i. 
*/
public int maxProduct(int length) {
  if(length <= 1) {
    return 0;
  }
  int[] m = new int[length+1];
  for(int i = 2; i <= length; i++) {
     for(int j = 1; j < i; j++) {
       m[i] = Math.max(m[i], Math.max(m[j], j) * (i-j));
     }
  }
  return m[length];
}

// Q2.
/*
eg: dictionary = [ab, cd]
string: abcd -> true
eg: dict = {bob, cat, rob}
word: bobcatrob

M[i] represents whether the first i words can be split into the dict words.

base case: M[0] = true
induction rule:
M[1] = b
  check the dict. 
M[2] = bo
  case1: bo 不切，就直接查dict
  case2: b|o 切1刀，左边是左大段，通过M[0]得知；右边是右小段，直接查dict
M[3] = bob
  case1: bob 
  case2: bo|b -> M[2] + 查dict
  case3: b|ob -> M[1] + 查dict

左大段是去m[] 中找，右小段是直接查dict
右小段是不可再分
再分也是可以做的，但是会有重复，就是右大段了
每次只考虑最后一刀就行，因为再多切的信息已经包含在过往的m[ ] 里了
*/

public boolean canBreak(String input, String[] dict) {
  int n = input.length();
  boolean[] m = new boolean[n+1];
  m[0] = true;
  for(int i = 1; i <= n; i++) {
    for(int j = 0; j < i; j++) { //j is cut from right to left
      if(m[j] && contains(input.substring(j, i), dict)) { //here, input[i] is not included, but input[i-1] is what m[i] means, since input[i-1] means the first i letters of input
        m[i] = true;
        continue;
      }
    }
  }
  return m[n];
}
private boolean contains(String input, String[] dict) {
  for(String s : dict) {
    if(s.equals(input)) { //notice: here should use equals to compare!
      return true;
    }
  }
  return false;
}


/*
写代码的坑：
m[] 是boolean的！！！not int[]
j是从右往左来切的，但是左大段是m[j], not m[i-j] （过例子）
如果题目给的是string[]，那需要自己写个contains函数
substring 小写，substring有2种用法：
  substring(begin index)
  substring(beginIndex, endindex): input[i, j). "hamburger".substring(4, 8) returns "urge"
这里因为i是word本身的index, 有个错位，从1开始，完美错位～
i = 1: bo, j = 0; substring(0, 1)就是b ?????????????????????
*/

public boolean canBreak(String input, String[] dict) {
  boolean[] m = new boolean[input.length() + 1];
  m[0] = true;
  for(int i = 1; i <= input.length(); i++) {
    for(int j = 0; j < i; j++) {
      if(m[j] && contains(input.substring(j, i), dict)) {
        m[i] = true;
      }
    }
    m[i] = false;
  }
  return m[input.length()];
}
private boolean contains(String input, String[] dict) {
  for(String s : dict) {
    if(input.equals(s)) {
      return true;
    }
  }
  return false;
}


//Q3. min cut to cut the word into a palidrome 
test cases: aba -> 0
abacdc -> 1

m[i] represents for i word (not index i), the min cuts to cut it into a palidrome
m[0] = 0
m[1] = a -> 0
m[2] = ab 
  case1: no cut
  case2: a|b -> m[1] + check whether the right side is palidrome
m[3] = aba
  case1: no cut
  case2: ab|a -> m[2] + check right
  case3: a|ba -> m[1] + check (j, i)
  
public int minCuts(String input) {
  int n = input.length();
  int[] m = new int[n+1];
  //must initialize the array, since the default is 0, no min cut is less than 0.
  for(int i = 2; i <= n; i++) {
    m[i] = n;
  }
  
  for(int i = 2; i <= n; i++) {
    if(isPalidrome(input, 0, i-1)) { //here 0, i-1 is the index
      m[i] = 0;
      continue;
    }
    for(int j = 1; j < i; j++) {
      // 写啥呢！傻了！if(m[j] && isPalidrome(input, j, i-1)) {
      if(isPalidrome(input, j, i-1)) {
        m[i] = Math.min(m[j] + 1, m[i]);
      }
    }
  }
  return m[n];
}
//startIndex and endIndex are all inclusive, and they are index, so different meaning of i in m[i].
private boolean isPalidrome(String input, int startIndex, int endIndex) {
  while(startIndex < endIndex) {
    if(input.charAt(startIndex++) != input.charAt(endIndex--)) {
      return false;
    }
  }
  return true;
}


     
  
  
  
  
  
  
  
  





