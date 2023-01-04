/**
 * Runtime complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    public int calPoints(String[] operations) {
        // The socres stored the socres.
        List<Integer> socres = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            char cur = operations[i].charAt(0);
            int length = socres.size();
            if (cur == '+') {
                socres.add(socres.get(length - 1) + socres.get(length - 2));
            } else if (cur == 'D') {
                socres.add(2 * socres.get(length - 1));
            } else if (cur == 'C'){
                socres.remove(length - 1);
            } else {
                socres.add(Integer.parseInt(operations[i]));
            }
        }

        int ans = 0;
        // Calcute the sum of the socres.
        for (int e : socres) {
            ans += e;
        }

        return ans;
    }
}