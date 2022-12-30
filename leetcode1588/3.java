/**
 * 思路：使用数学方法来解决这个题目。原来的方法是求奇数数组的和。现在换一种思路，求当前数在多少个奇数数组出现过。
 * 1.当一个数的左边和右边元素的个数同时是奇数或者偶数的时候，这个数一定存在于一个奇数数组当中。
 * 2.设当前元素左边元素的个数为leftCount=i，右边元素的个数为rightCount = n - i - 1。
 * 3.当元素左右两边为奇数时，左边奇数的个数是leftOdd=(leftCount + 1) / 2, rightOdd=(rightCount+1)/2。
 * 4.当元素左右两边为偶数时，左边偶数的个数是leftEven=(leftCount) / 2 + 1, rightEven=(right) / 2 + 1。
 * 5.note:如果leftCount的值和rightCount一个为奇数，另一个为偶数。也没有关系，还是既然可以计算出leftOdd和rightOdd，以及leftEven和rightEven的值。
 */

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        // 记录奇数数组的和
        int count = 0;

        // 遍历数组的元素，计算每一个元素出现在奇数数组的次数
        for (int i = 0; i < arr.length; i++) {
            // 当前元素左边元素的个数和右边元素的个数
            int leftCount = i, rightCount = arr.length - i - 1;
            // 当前元素左边和右边奇数元素的个数
            int leftOdd = (leftCount + 1) >> 1, rightOdd = (rightCount + 1) >> 1;
            // 当前元素左边和右边偶数元素的个数
            int leftEven = (leftCount >> 1) + 1, rightEven = (rightCount >> 1) + 1;

            // 计算当前元素对最后结果的贡献。
            count += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }

        return count;
    }
}