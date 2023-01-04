/**
 * Runtime complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    // The socres stored the socres.
    static int[] socres = new int[1001];
    public int calPoints(String[] operations) {
        // The position of the socres.
        int index = 0;
        for (String e : operations) {
            if ("+".equals(e)) {
                socres[index] = socres[index - 1] + socres[index - 2];
                index++;
            } else if ("C".equals(e)) {
                index--;
            } else if ("D".equals(e)) {
                socres[index] = 2 * socres[index - 1];
                index++;
            } else {
                socres[index++] = Integer.parseInt(e);
            }
        }

        // The ans stored the final answer.
        int ans = 0;
        for (int i = 0; i < index; i++) {
            ans += socres[i];
        }

        return ans;
    }
}