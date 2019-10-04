/*
The idea is simple, the trick is that we should put INDEX into stack, so that we can know how many paris have been matched.
We cannot use a pointer to replace the stack (like xiaoxiaole), because the index in stack may be not consecutive.
Idea:
scan the string, 
if the current char is a left parenthese, just put it into the stack;
if it is the right one, we should check whether it can be matched with the last one:
  if it can be matched, great, pop the last one, and we should update the max;
  if it cannot be matched, need to push it to stack, to mark the position. so the next time, when we update the max, it can be used as a partition.
Notice1: here we cannot update max and then poll (to avoid null), because the index in stack may be NOT consecutive.
  That happens when there is already a pair/pairs have been matched before.
  for example: )()()
  so in the stack, when we want to update the second max, 2 vs 4
Notice1.1: another way is to push -1 in stack initially. 
*/

public class Solution {
  public int longestValidP(String s) {
    int max = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for(int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);
      if(curr == '(') {
        stack.offerFirst(i);
      } else {
        if(!stack.isEmpty() && stack.peek() == '(') {
          stack.pollFirst();
          max = Math.max(max, i - (stack.isEmpty() ? -1 : stack.peek())); // Notice1
        } else {
          stack.offerFirst(i);
        }
      }
    }
    return stack.isEmpty() ? s.length() : max;
  }
}


