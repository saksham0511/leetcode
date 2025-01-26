package greedy;

public class GetMaxScore {
    class Solution {
        // Keep the sum of both the arrays till the common is found. Now, out of this sum of both arrays, the max can be picked
        // Reset both the sums to zero now, and add the common element to the answer.
        public int maxSum(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int i = 0, j = 0;
            int sum1 = 0, sum2 = 0, ans = 0;
            while (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    sum1 += nums1[i];
                    i++;
                } else if (nums2[j] < nums1[i]) {
                    sum2 += nums2[j];
                    j++;
                } else if (nums2[j] == nums1[i]) {
                    ans += nums1[i] + Math.max(sum1, sum2);
                    sum1 = 0; sum2 = 0;
                    i++; j++;
                }
            }
            while (i < m) {
                sum1 += nums1[i];
                i++;
            }
            while (j < n) {
                sum2 += nums2[j];
                j++;
            }
            ans += Math.max(sum1, sum2);
            return ans;
        }
    }
}
