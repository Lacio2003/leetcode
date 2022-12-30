/**
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public String reverseStr(String s, int k) {
        // For easy of use, the length of len is stored in a variable.
        int len = s.length();

        // For easy fo use, convert the String to the char array.
        char[] arr = s.toCharArray();
        for (int i = 0; i < len; i += 2 * k) {
            swap(arr, i, Math.min(i + k - 1, len - 1));
        }

        return String.valueOf(arr);
    }

    /**
     * Swap the string in a range.
     */
    private void swap(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}