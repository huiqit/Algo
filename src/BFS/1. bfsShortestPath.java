
class Node {
  int id; 
  List<Node> neighbors;
}
int bfs(Node root, Node target) {
  Queue<Node> queue = new ArrayDeque<>();
  queue.offer(root);
  HashSet<Node> set = new HashSet<>();
  set.add(root);
  int level = 0;
  while(!queue.isEmpty()) {
    int size = queue.size();
    for(int i = 0; i < size; i++) {
      TreeNode curr = queue.poll();
      for(Node nei : curr.neightbors) {
        if(nei == target) {
          return level + 1;
        }
        if(set.add(nei)) {
          queue.offer(nei);
        }
      }
    }
    level++;
  }
  return -1;
}

List<Node> bfs(Node root, Node target) {
  Queue<Node> queue = new ArrayDeque<>();
  List<Node> res = new ArrayList<>();
  Map<Node, List<Node>> map = new HashMap<>(); // a list of parent nodes
  queue.offer(root);
  map.put(root, null);
  while(!queue.isEmpty()) {
    Node curr = queue.poll();
    /* ide试一下，应该也对
    for(Node nei : neighbors) {
      if(!map.containsKey(nei)) {
        map.put(nei, new ArrayList<>());
      }
      map.get(nei).add(curr);
    }
    */
    for(Node nei : neighbors) {
      if(nei == target) {
        return getPath(root, nei, map); // use a helper function to get the path from root to nei(target)
      }
      List<Node> currList = map.getOrDefault(nei, new ArrayList<>());
      currList.add(curr);
      map.put(nei, currList);
    }
  }
  return res;
}
private List<Node> getPath(Node root, Node target, Map<Node, List<Node>> map) {
  List<Node> res = new ArrayList<>();
  Node curr = target;
  while(curr != root) {
    res.add(curr);
    Node next = map.get(curr).get(0);
    curr = next;
  }
  return Collections.reverse(res);
}
  
    
    
    
    
    
    
    
    
