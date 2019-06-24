Here we propose FOUR questions:
一、从下往上返值，三部曲。解决人字形问题。bottom-up way

二、carry path prefix while pre order traversal. 直上直下的path求maxSum。应用dp prefix sum思想。
  2.1 max path from leaf to root. 从头到尾的最大路径。(notes)
  2.2 判断boolean：一条path上的any node to any node之和 = target (#141, #440)
  2.3 max: 一条path上any node to any node之和.
  
三、Tree Serialization 
  3.1 binary tree -> doubly linked list, in in-order sequence.
  
四、De-serialization. 
  4.1 reconstruct a tree with pre-order and in-order sequences.
  4.2 reconstruct a BST with post-order sequences.
  4.3 construct a tree from inorder and level order traversal

