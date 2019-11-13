class Node {
  int id;
  List<Node> neighbors;
}

List<Node> shortestPath(Node root, Node target) {
  Queue<Node> queue = new ArrayDeque<>();
  Map<Node, Node> map = new HashMap<>(); //记录parent node
  queue.offer(root);
  
  while(!queue.isEmpty()) {
    Node curr = queue.poll();
    
    for(Node nei : curr.neighbors) {
      if(nei == target) {
        map.put(nei, curr);
        return reconstruct(map, target);
      }
      if(!map.containsKey(nei)) {
        map.put(nei, curr);
      }
    }
  }
  return new ArrayList<>();
}

List<Node> reconstruct(Map<Node, Node> map, Node target) {
  List<Node> list = new ArrayList<>();
  list.add(target);

  while(target != null) {
    parent = map.get(target);
    list.add(parent);
    target = parent;
  }
  return Collections.reverse(list);
}
  
