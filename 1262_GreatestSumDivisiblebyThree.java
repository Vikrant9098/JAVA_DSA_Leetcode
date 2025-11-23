class Solution {
    public int maxSumDivThree(int[] nums) {

        int sum = 0; // store total sum of array

        List<Integer> rem1 = new ArrayList<>(); // list for numbers giving remainder 1
        List<Integer> rem2 = new ArrayList<>(); // list for numbers giving remainder 2

        for (int num : nums) {       // loop through each number
            sum += num;              // add number to total sum

            if (num % 3 == 1)        // if remainder after dividing by 3 is 1
                rem1.add(num);       // store it in remainder 1 list

            else if (num % 3 == 2)   // if remainder is 2
                rem2.add(num);       // store it in remainder 2 list
        }

        if (sum % 3 == 0)            // if sum is already divisible by 3
            return sum;              // return as answer

        Collections.sort(rem1);      // sort remainder 1 list (smallest first)
        Collections.sort(rem2);      // sort remainder 2 list (smallest first)

        int remainder = sum % 3;     // store the remainder of total sum

        if (remainder == 1) {        // if remainder is 1
            int option1 = rem1.size() >= 1 ? sum - rem1.get(0) : 0;        // remove smallest rem=1 number
            int option2 = rem2.size() >= 2 ? sum - rem2.get(0) - rem2.get(1) : 0;  // or remove two smallest rem=2 numbers
            return Math.max(option1, option2);   // return maximum result
        } 
        else {                       // remainder must be 2
            int option1 = rem2.size() >= 1 ? sum - rem2.get(0) : 0;        // remove smallest rem=2 number
            int option2 = rem1.size() >= 2 ? sum - rem1.get(0) - rem1.get(1) : 0;  // or remove two smallest rem=1 numbers
            return Math.max(option1, option2);   // return maximum result
        }
    }
}
