/**
 * Runtime complexity:O(n^3)
 * Space complexity:O(1)
 */
class Solution {
    public double largestTriangleArea(int[][] points) {
        // The area of the largest triangle.
        double max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    // Get the three points.
                    int fir[] = points[i], sec[] = points[j], thir[] = points[k];
                    // Calclate the area.
                    double area = 0.5 * Math.abs((fir[0] * (sec[1] - thir[1]) + sec[0] * (thir[1] - fir[1]) + thir[0] * (fir[1] - sec[1])));
                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }
}