package dp;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1};
        boolean isPossible = Solution.canPartition(nums);
        System.out.println("The array can be divided into equal partitions : " + isPossible);
    }
    static class Solution {
        public static boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }
            if (sum%2 != 0) {
                return false;
            }
            boolean[] dp = new boolean[sum/2+1];
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                for (int j = sum/2; j>0;j--) {
                    if (j-nums[i] >= 0) {
                        dp[j] = dp[j-nums[i]];
                    }
                }
            }
            return dp[sum/2];
        }
    }

}
