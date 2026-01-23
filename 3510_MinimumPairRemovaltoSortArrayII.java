/*
Idea:
- use a doubly linked list to represent the array
- maintain a TreeSet of nodes sorted by the sum of each node and its right neighbour
- always merge the adjacent pair with the minimum sum (leftmost on ties)
- track the number of decreasing pairs to know when the array becomes non-decreasing
- each merge updates only local neighbours, giving O(n log n) complexity
*/

class Solution {
    class Node implements Comparable<Node> {
        int idx;
        long val;
        long sum;
        Node left = null;
        Node right = null;
        Node(int idx, long val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Node n) {
            // if either of 'this' or 'n' next is null
            if (this.right == null || n.right == null) {
                // 'n' comes before and 'this' node comes at last
                if (this.right == null) return 1;

                // 'this' node comes before and 'n' comes at last
                else return -1;
            }

            // sort on the basis of min sum
            if (this.sum != n.sum) {
                // if 'this' has smaller sum than 'n', 'this' comes before 'n'
                if (this.sum < n.sum) return -1;

                // 'n' comes before 'this'
                else return 1;
            }

            // when sum of 'this' and 'n' equal, sort on basis of smaller idx
            return this.idx - n.idx;
        }
    }
    public int minimumPairRemoval(int[] nums) {
        // time complexity - O(n log n); due to tset insertions and removals
        // space complexity - O(n); tset and DLL nodes
        
        // we need to make the array 'non-decreasing'

        // to store the node in sorted order on basis on min sum
        TreeSet<Node> tset = new TreeSet<>();

        // disordered (decreasing) pairs
        int disorder = 0;

        int minOp = 0;

        Node prev = null;

        for (int i=0; i<nums.length; i++) {
            // create a node
            Node curr = new Node(i,nums[i]);

            // for the first iteration
            if (prev == null) {
                prev = curr;
            } else {
                // check for disordered pair
                if (prev.val > curr.val) disorder++;

                // form a DLL between the two pair of nodes
                prev.right = curr;
                curr.left = prev;

                // update the node properties
                prev.sum = prev.val + curr.val;

                // add the 'prev' node to tset
                tset.add(prev);

                // update 'prev'
                prev = curr;
            }
        }

        // add the last 'prev'
        tset.add(prev);

        // while any disorder pair exists
        while (disorder > 0) {
            // remove the first element from tset
            Node minSumNode = tset.pollFirst();

            // if already decreasing
            if (minSumNode.right.val < minSumNode.val) disorder--;

            // merge minSumNode with its right neighbour and update values
            minSumNode.sum = minSumNode.val + minSumNode.right.sum;
            minSumNode.val = minSumNode.val + minSumNode.right.val;

            // the node to be deleted after merging
            Node nodeDel = minSumNode.right;
            
            // update the links
            minSumNode.right = nodeDel.right;

            // before pointing the nodeDel.right to minSumNode check if it is null
            if (nodeDel.right != null) {
                // change disorder associated with nodeDel since it is being deleted
                if (nodeDel.right.val < nodeDel.val) disorder--;

                // point the right node of nodeDel to minSumNode
                nodeDel.right.left = minSumNode;

                // now check the newly formed pair, if disordered or not
                if (minSumNode.val > minSumNode.right.val) disorder++;
            }

            // remove the nodeDel from tset also and add the updated minSumNode
            tset.remove(nodeDel);
            tset.add(minSumNode);

            // update left neighbour after merging minSumNode with its right node
            Node prevToMinSumNode = minSumNode.left;

            if (prevToMinSumNode != null) {
                // remove it from tset
                tset.remove(prevToMinSumNode);

                // check if it was disordered earlier
                if (prevToMinSumNode.val > prevToMinSumNode.sum - prevToMinSumNode.val) disorder--;
                // now check for current condition
                if (prevToMinSumNode.val > minSumNode.val) disorder++;

                // update sum for prevToMinSumNode
                prevToMinSumNode.sum = prevToMinSumNode.val + minSumNode.val;

                // add updated prevToMinSumNode to tset
                tset.add(prevToMinSumNode);
            }

            // update minOp whenever the loop runs
            minOp++;
        }

        return minOp;
    }
}