class TrieNode {
  Map<Character, TrieNode> children;
  boolean isWord;
  String value;
}

class TrieNode {
  TrieNode[] children;
  boolean isWord;
  String value;
}

// Search
public boolean search(String word, TrieNode root) {
  TrieNode curr = root;
  for(int i = 0; i < word.length(); i++) {
    TrieNode nxt = curr.children.get(word.charAt(i));
    if(nxt == null) {
      return false;
    }
    curr = nxt;
  }
  return curr.isWord;
}

// insert
public boolean insert(String word, TrieNode root) {
  if(search(word, root)) {
    return false;
  }
  TrieNode curr = root;
  for(int i = 0; i < word.length(); i++) {
    char currChar = word.charAt(i);
    TrieNode nxt = curr.children.get(currChar);
    if(nxt == null) {
      //TrieNode node = new TrieNode(currChar);
      nxt = new TrieNode();
      curr.children.put(currChar, nxt);
    }
    curr = nxt;
    //curr.count++;
  }
  curr.isWord = true;
  curr.count++;
  return true;
}
      

// delete
public boolean delete(String word, TrieNode root) {
  if(!search(word, root)) {
    return false;
  } 
  TrieNode curr = root;
  for(int i = 0; i < word.length(); i++) {
    TrieNode nxt = curr.children.get(word.charAt(i));
    nxt.count--;
    if(nxt.count == 0) {
      curr.children.remove(word.charAt(i));
      return true;
    } 
    curr = nxt;
  }
  curr.isWord = false;
  return true;
}
      
      
      
      
      
      
      
      

