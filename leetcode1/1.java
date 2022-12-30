/**
 * Ideas:Simulate according to the requirements of the topic.
 * Time complexity:O(n^2)
 * Spatial complexity:O(1).Arras that return answer are not counted.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // An array that stores answers.
        int[] ans = new int[2];

        // Look for numbers that meet the requirements.
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
					break;
                }
            }
        }

        // return answer.
        return ans;
    }
}