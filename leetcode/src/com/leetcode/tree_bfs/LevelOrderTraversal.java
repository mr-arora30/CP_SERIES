package com.leetcode.tree_bfs;

import java.util.*;
/* do a level order traversal in tree*/

//expected op: [[12], [7, 1], [9, 10, 5]]
public class LevelOrderTraversal{

   public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null)
      return result;

    Queue<TreeNode> queue = new LinkedList<>(); //we use queue in bfs as we need FIFO to acess all the nodes at level
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList<>(levelSize);
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();
        // add the node to the current level
        currentLevel.add(currentNode.val);
        // insert the children of current node in the queue
        if (currentNode.left != null)
          queue.offer(currentNode.left);
        if (currentNode.right != null)
          queue.offer(currentNode.right);
      }
      result.add(currentLevel);
    }

    return result;
  }
    /*
    Time complexity#
The time complexity of the above algorithm is O(N)O(N), where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once.

Space complexity#
The space complexity of the above algorithm will be O(N)O(N) as we need to return a list containing the level order traversal. We will also need O(N)O(N) space for the queue. Since we can have a maximum of N/2N/2 nodes at any level (this could happen only at the lowest level), therefore we will need O(N)O(N) space to store them in the queue.
    */
    public static void main(String args[]){
      TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = LevelOrderTraversal.traverse(root);
     System.out.println("Level order traversal: " + result);
    }
   static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
}
