class Solution {
    public int numberOfBeams(String[] bank) {
        // Store the total number of beams
        int totalBeams = 0;
        
        // Store the number of devices in the previous non-empty row
        int prevDevices = 0;
        
        // Loop through each row in the bank
        for (String row : bank) {
            
            // Count devices ('1's) in the current row
            int currDevices = 0;
            for (char c : row.toCharArray()) { // convert string to char array
                if (c == '1') { // if device found
                    currDevices++; // increase count
                }
            }
            
            // If no devices in this row, skip it
            if (currDevices == 0) continue;
            
            // Add beams between current row and previous non-empty row
            totalBeams += prevDevices * currDevices;
            
            // Update previous row device count
            prevDevices = currDevices;
        }
        
        // Return total beams
        return totalBeams;
    }
}
