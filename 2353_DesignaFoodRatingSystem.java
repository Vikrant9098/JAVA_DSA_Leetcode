import java.util.*; // Import utility classes like HashMap, TreeSet, Comparator

class FoodRatings {
    // Map each food -> its cuisine
    private Map<String, String> foodToCuisine;
    
    // Map each food -> its rating
    private Map<String, Integer> foodToRating;
    
    // Map each cuisine -> all foods in it (stored in TreeSet for sorting)
    private Map<String, TreeSet<String>> cuisineToFoods;

    // Constructor: initializes data structures with given foods, cuisines, and ratings
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        // Initialize the maps
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        // Loop through all foods to fill mappings
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];       // Current food name
            String cuisine = cuisines[i]; // Cuisine of this food
            int rating = ratings[i];      // Rating of this food

            // Map food -> cuisine
            foodToCuisine.put(food, cuisine);

            // Map food -> rating
            foodToRating.put(food, rating);

            // If this cuisine is not in map, initialize a TreeSet for it
            // TreeSet uses custom comparator: highest rating first, tie-break by lexicographical order
            cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>(
                (a, b) -> {
                    int rateA = foodToRating.get(a); // rating of food a
                    int rateB = foodToRating.get(b); // rating of food b
                    if (rateA != rateB) {
                        return rateB - rateA; // Higher rating comes first
                    }
                    return a.compareTo(b); // If same rating, lexicographically smaller first
                }
            ));

            // Add the food to this cuisine's TreeSet
            cuisineToFoods.get(cuisine).add(food);
        }
    }

    // Change the rating of a given food
    public void changeRating(String food, int newRating) {
        // Get its cuisine
        String cuisine = foodToCuisine.get(food);

        // Remove the food from TreeSet (since its rating will change and ordering may break)
        cuisineToFoods.get(cuisine).remove(food);

        // Update the rating in the map
        foodToRating.put(food, newRating);

        // Re-insert food with updated rating into TreeSet (TreeSet reorders automatically)
        cuisineToFoods.get(cuisine).add(food);
    }

    // Get the highest-rated food for a given cuisine
    public String highestRated(String cuisine) {
        // First element in TreeSet is the highest-rated food (because of custom comparator)
        return cuisineToFoods.get(cuisine).first();
    }
}

/**
 * Example usage:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food, newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
