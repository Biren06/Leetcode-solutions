class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
       Set<Integer> filteredIndices = new HashSet<>(); // Store indices
        Set<Integer> filteredNumbers = new HashSet<>(); // Store numbers
        HashMap<Integer, Integer> indexMap = new HashMap<>(); // Store number → index

        // Step 1: Filter elements and store their indices
        for (int i = 0; i < nums.length; i++) {
            filteredIndices.add(i);
            filteredNumbers.add(nums[i]);
            indexMap.put(nums[i], i); // Store number with its index
        }

        // Step 2: Check for a pair that sums to the target
        for (int i : filteredIndices) {  
            int complement = target - nums[i];

            if (filteredNumbers.contains(complement)) { 
                int j = indexMap.get(complement);
                if (i != j) { // Ensure we don’t use the same element twice
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; 
    }
}
