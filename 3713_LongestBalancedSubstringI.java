class Solution {  

    // Function to find the length of longest substring 
    // where all characters have same frequency
    public int longestBalanced(String s) {  

        int max = 0;  // To store maximum length found
        int n = s.length();  // Length of the string
                 
        // Outer loop → starting index of substring
        for(int i = 0; i < n; i++){  

            int freq[] = new int[26];  
            // Array to store frequency of each character (a–z)

            // Inner loop → ending index of substring
            for(int j = i; j < n; j++){  

                char ch = s.charAt(j);  
                // Get current character

                freq[ch - 'a']++;  
                // Increase frequency of that character
                 
                // Check if all non-zero frequencies are same
                if(issamefreq(freq)){  

                    max = Math.max(max, j - i + 1);  
                    // Update max length if valid substring found
                }
            }
        }

        return max;  // Return the longest valid substring length
    }

    // Function to check if all non-zero frequencies are equal
    public static boolean issamefreq(int arr[]){  

        int value = 0;  
        // Stores the first non-zero frequency

        for(int a : arr){  
            // Traverse frequency array

            if(a == 0) continue;  
            // Ignore characters not present

            if(value == 0)  
                value = a;  
                // Store first non-zero frequency

            else if(value != a)  
                return false;  
                // If any frequency differs, return false
        }

        return true;  
        // All non-zero frequencies are same
    }
}
