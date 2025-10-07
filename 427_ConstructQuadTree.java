/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        // start recursive construction of Quad Tree from full grid
        return build(grid, 0, 0, grid.length);
    }

    // helper function to build Quad Tree
    private Node build(int[][] grid, int row, int col, int size) {
        // check if the current sub-grid has all same values
        if (isUniform(grid, row, col, size)) {
            // create a leaf node with that value
            return new Node(grid[row][col] == 1, true);
        }

        // divide grid into 4 equal parts
        int newSize = size / 2;

        // build top-left part recursively
        Node topLeft = build(grid, row, col, newSize);

        // build top-right part recursively
        Node topRight = build(grid, row, col + newSize, newSize);

        // build bottom-left part recursively
        Node bottomLeft = build(grid, row + newSize, col, newSize);

        // build bottom-right part recursively
        Node bottomRight = build(grid, row + newSize, col + newSize, newSize);

        // current node is not a leaf, combine children
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    // helper function to check if sub-grid has same values
    private boolean isUniform(int[][] grid, int row, int col, int size) {
        // take the first cell value as reference
        int val = grid[row][col];

        // loop through sub-grid
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                // if any value differs, return false
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        // all values same → uniform grid
        return true;
    }
}
