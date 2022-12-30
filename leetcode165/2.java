/**
 * Cut the string by ".", then paragraph by parapraph comparision.
 * Time complexity:O(Max(length))
 * Spcae complexity:O(n + m)
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        // Cut the string by "."
        String[] ver1 = version1.split("\\."), ver2 = version2.split("\\.");

        for (int i = 0, j = 0; i < ver1.length || j < ver2.length; i++, j++) {
            // Convert the string number to Integer.
            int num1 = i >= ver1.length ? 0 : Integer.parseInt(ver1[i]);
            int num2 = j >= ver2.length ? 0 : Integer.parseInt(ver2[j]);

            // Compare two numbers. 
            if (num1 != num2) {
                return num1 > num2 ? 1 : -1;
            }
        }

        // The program can executed, indicates that two strings are equals
        return 0;
    }
}