class SummaryRanges {

  // Add a new number to the stream
  public void addNum(int val) {
    if (map.containsKey(val))
      return; // if val already exists, skip it

    final Integer lo = map.lowerKey(val);  // get the greatest key smaller than val
    final Integer hi = map.higherKey(val); // get the smallest key greater than val

    // Case 1: val connects two intervals → merge them into one
    // Example: {lo, map.get(lo)[1]} + val + {hi, map.get(hi)[1]} → {lo, map.get(hi)[1]}
    if (lo != null && hi != null && map.get(lo)[1] + 1 == val && val + 1 == hi) {
      map.get(lo)[1] = map.get(hi)[1]; // extend lo’s interval to hi’s end
      map.remove(hi); // remove hi interval (merged)
    
    // Case 2: val extends the lower interval
    // Example: {lo, map.get(lo)[1]} + val → {lo, val}
    } else if (lo != null && map.get(lo)[1] + 1 >= val) {
      map.get(lo)[1] = Math.max(map.get(lo)[1], val); // extend lo’s end to val if needed
    
    // Case 3: val extends the higher interval from the left
    // Example: val + {hi, map.get(hi)[1]} → {val, map.get(hi)[1]}
    } else if (hi != null && val + 1 == hi) {
      map.put(val, new int[] {val, map.get(hi)[1]}); // create new interval starting at val
      map.remove(hi); // remove old hi interval (merged)
    
    // Case 4: val is isolated → new single-element interval
    } else {
      map.put(val, new int[] {val, val});
    }
  }

  // Return all current intervals as a 2D array
  public int[][] getIntervals() {
    List<int[]> intervals = new ArrayList<>(map.values()); // get all intervals from map
    return intervals.toArray(new int[intervals.size()][]); // convert list to 2D array
  }

  // TreeMap to store intervals as {start → [start, end]}
  private TreeMap<Integer, int[]> map = new TreeMap<>();
}
