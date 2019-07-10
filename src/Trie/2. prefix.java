//1. find the node matchNode associated with prefix 
//2. do DFS on the subtree rooted at matchNode
/*
prefix = "ca"
dict = {"cat", "cap", ...}
     o
    / \
   c   ...
   |
   a
  / \
 t   p
so, here matchNode = TrieNode 'a'
 
*/
class TrieNode {
  TrieNode root;
  Map<Character, TrieNode> children;
  boolean isWord;
  TrieNode() {
    children = new HashMap<>();
  }
}
public List<String> findAllWordsWithPrefix(TrieNode root, String prefix) {
  TrieNode matchNode = searchNode(root, prefix);
  List<String> res = new ArrayList<>();
  if(matchNode == null) {
    return res;
  }
  helper(matchNode, new StringBuilder(prefix), res);
  return res;
}
private void helper(TrieNode curr, StringBuilder path, List<String> res) {
  if(curr.isWord) {
    res.add(curr.toString());
  }
  for(Entry<Character, TrieNode> entry : curr.children.EntrySet()) {
    path.append(entry.getKey());
    helper(entry.getValue(), path, res);
    path.deleteCharAt(path.length() - 1);
  }
}

private TrieNode searchNode(TrieNode root, String word) {
  TrieNode curr = root;
  for(int i = 0; i < word.length(); i++) {
    TrieNode next = curr.children.get(word.charAt(i));
    if(next == null) {
      return null;
    }
    curr = next;
  }
  return curr;
}

  
