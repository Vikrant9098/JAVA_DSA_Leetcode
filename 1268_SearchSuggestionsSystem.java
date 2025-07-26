class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Sort the products lexicographically to get lexicographically smallest suggestions
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();
        StringBuilder prefix = new StringBuilder(); // To build the prefix character by character

        // For each character typed in searchWord
        for (char ch : searchWord.toCharArray()) {
            prefix.append(ch); // Append the character to the prefix
            List<String> suggestions = new ArrayList<>();

            // Iterate over sorted products
            for (String product : products) {
                // If product starts with the current prefix
                if (product.startsWith(prefix.toString())) {
                    suggestions.add(product); // Add to the suggestion list
                    if (suggestions.size() == 3) break; // Only need up to 3 suggestions
                }
            }

            result.add(suggestions); // Add current suggestions to the result
        }

        return result;
    }
}
