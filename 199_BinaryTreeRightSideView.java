// Definition for a binary tree node.
class TreeNode {
    int val;              // value of the current node
    TreeNode left;        // pointer to the left child
    TreeNode right;       // pointer to the right child

    TreeNode() {}         // default constructor

    TreeNode(int val) {   // constructor with value
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) { // constructor with value and children
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // list to store the right side view

        if (root == null) {
            return result; // if tree is empty, return empty list
        }

        Queue<TreeNode> queue = new LinkedList<>(); // queue for level-order traversal (BFS)
        queue.offer(root); // add root node to the queue

        while (!queue.isEmpty()) { // continue until queue is empty
            int levelSize = queue.size(); // number of nodes at current level

            for (int i = 0; i < levelSize; i++) { // iterate over all nodes in this level
                TreeNode current = queue.poll(); // remove node from queue

                if (i == levelSize - 1) { // if it's the last node in this level
                    result.add(current.val); // add it to the result list
                }

                if (current.left != null) { // if left child exists
                    queue.offer(current.left); // add left child to the queue
                }

                if (current.right != null) { // if right child exists
                    queue.offer(current.right); // add right child to the queue
                }
            }
        }

        return result; // return the right view of the tree
    }
}
