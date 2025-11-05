class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(","); // split the input string by commas
        int slots = 1; // one slot for the root node

        // go through each node in the list
        for (String node : nodes) {
            slots--; // each node uses one slot
            if (slots < 0) return false; // if no slot left, it's invalid

            if (!node.equals("#")) { // if node is not null
                slots += 2; // add two new slots for its children
            }
        }

        return slots == 0; // valid only if all slots are exactly used
    }
}
