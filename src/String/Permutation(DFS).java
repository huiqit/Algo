/*
Given a string with duplicate letters, print out all permutations.
eg: "aab", return "aab", "aba", "baa".

we can use DFS(Depth First Search) to do it.
the recursion tree has n levels (n is the number of letters).
for each level, we have n
level 0       		()
level 1			 a(ab)   b(aa)
level 2 aa(b) ab(a)  ba(a)
level 3 aab   aba    baa

*/
public List<String> permutations(String input) {
	List<String> res = new ArrayList<>();
	if(input == null) {
		return res;
	} 
	String[] array = input.toCharArray();
	return permutations(array, 0, res);
}

private List<String> permutations(char[] array, int index, List<String> res) {
	 if(index == array.length) {
	 		res.add(new String(array));
			return;
	 }
	 Set<Character> usedChar = new HashSet<>();
	 for(int i = index; i < array.length; i++) {
	 		if(!usedChar.contains(array[i]) {
					usedChar.add(array[i]);
					swap(array, index, i);
					permutations(array, index + 1, res);
					swap(array, index, i);
	 }
	 return res;
}
private void swap(char[] array, int x, int y) {
		char tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
}


			
			
			
