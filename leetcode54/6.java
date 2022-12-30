/**
 * Use abscissa and ordinate for traversal.
 * Time compelxity:O(mn)
 * Space complexity:O(1)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // The ans stores the numbers of the matrix.
        List<Integer> ans = new ArrayList<>();
        // For easy of use, the length of matrix is stored in variable.
        int m = matrix.length, n = matrix[0].length;
        // Abscissa and ordinate
        int x0 = 0, y0 = 0, x1 = m - 1, y1 = n - 1;

        while (x0 <= x1 && y0 <= y1) {
            // Only one line remains.
            if (x0 == x1) {
                for (int i = y0; i <= y1; i++) {
                    ans.add(matrix[x0][i]);
                }
                break;
            }

            // Only one column remains.
            if (y0 == y1) {
                for (int i = x0; i <= x1; i++) {
                    ans.add(matrix[i][y0]);
                }
                break;
            }

            for (int i = y0; i < y1; i++) ans.add(matrix[x0][i]);
            for (int i = x0; i < x1; i++) ans.add(matrix[i][y1]);
            for (int i = y1; i > y0; i--) ans.add(matrix[x1][i]);
            for (int i = x1; i > x0; i--) ans.add(matrix[i][y0]);

            // Narrow it down
            x0++; 
            y0++; 
            x1--; 
            y1--;
        }

        return ans;
    }
}