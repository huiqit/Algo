//basic operations

class TrieNode {
  TrieNode root;
  Map<Character, TrieNode> children;
	boolean isWord;
	int count;
	TrieNode() {
	  children = new HashMap<>();
	}
}

//search
public boolean search(TrieNode root, String word) {
  TrieNode curr = root;
	for(int i = 0; i < word.length(); i++) {
	  TrieNode next = curr.children.get(word.charAt(i));
		if(next == null) {
		  return false;
		}
		curr = next;
	}
	return curr.isWord;
}

//insert
//if can insert, return true;
//if cannot insert, which means the world already exist in the Trie, return false.
public boolean insert(TrieNode root, String word) {
  if(search(word)) {
	  return false;
	}
	TrieNode curr = root;
	for(int i = 0; i < word.length(); i++) {
	  TrieNode next = curr.children.get(word.charAt(i));
		if(next == null) {
		  curr.children.put(word.charAt(i), next);
		}
		curr = next;
	}
	curr.isWorld = true;
	return true;
}

//delete
public boolean delete(String word, TrieNode root) {
  if(!search(root)) {
	  return false;
	}
	TrieNode curr = root;
	for(int i = 0; i < world.length(); i++) {
	  TrieNode next = curr.children.get(world.charAt(i));
		next.count--;
		if(next.count == 0) {
		  curr.children.remove(word.charAt(i));
			return true;
		}
	  curr = next;
	}
	curr.isWord = false;
	return true;
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


