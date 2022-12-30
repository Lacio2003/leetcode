/**
 * website:https://leetcode.cn/problems/fraction-to-recurring-decimal/solutions/1028784/gong-shui-san-xie-mo-ni-shu-shi-ji-suan-kq8c4/
 * Time complexity:O(n);
 * Space complexity:O(n)
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // To prevent overflow, convert numerator and denominator to long.
        long num1 = numerator, num2 = denominator;
        if (num1 % num2 == 0) {
            // It can be divisble and return directly.
            return String.valueOf(num1 / num2);
        }

        // The ans stores the final answer.
        StringBuilder ans = new StringBuilder();
        if (num1 * num2 < 0) {
            // The result is a negative number.
            ans.append('-');
        }

        // Convert numbers to positive number.
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);

        // Calculate the integer part.
        ans.append((num1 / num2) + ".");
        // Use a hash table to check for circular decimals.
        Map<Long, Integer> map = new HashMap<>();
        long remainder = num1 % num2;

        // If the remainder is equal to 0, the number is not a circular decimal.
        while (remainder != 0) {
            map.put(remainder, ans.length());
            remainder *= 10;
            long cur = remainder / num2;
            remainder %= num2;
            ans.append(cur);
            if (map.containsKey(remainder)) {
                // The number is a circular decimal.
                // Add the bracket.
                ans.insert(map.get(remainder), "(");
                ans.append(")");
                break;
            }
        }

        return ans.toString();
    }
}