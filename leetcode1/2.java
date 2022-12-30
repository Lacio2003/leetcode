/**
 * Idea:Storge the elements in the HashTable.Look for the (target - nums[i])
 * in the HashTable.
 * Reduce time complexity.
 * time complexity:O(n)
 * Spatial complexity:O(1).The array that return answer is not counted.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // The array that storges answer.
        int[] ans = new int[2];
        // The HashMap that storges the numbers of target.
        Map<Integer, Integer> hash = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            // Look for another numbers in the HashMap.
            int numFind = target - nums[i];
            // If exist and the indices is different,it meets the requirements.
            if (hash.containsKey(numFind)) {
                ans[0] = i;
                ans[1] = hash.get(numFind);
                // Stop the loop
                break;
            }
            // Store the elements in the HashMap.`
            hash.put(nums[i], i);
        }

        return ans;
    }
}