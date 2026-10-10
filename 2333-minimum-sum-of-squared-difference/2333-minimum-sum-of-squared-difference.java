import java.util.Arrays;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long totalK = (long) k1 + k2;
        long sumDiff = 0;
        
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sumDiff += diff[i];
        }
        
        if (sumDiff <= totalK) {
            return 0;
        }
        
        int[] count = new int[100001];
        int maxDiff = 0;
        for (int d : diff) {
            count[d]++;
            if (d > maxDiff) {
                maxDiff = d;
            }
        }
        
        for (int i = maxDiff; i > 0 && totalK > 0; i--) {
            if (count[i] == 0) continue;
            long take = Math.min((long) count[i], totalK);
            count[i] -= take;
            count[i - 1] += take;
            totalK -= take;
        }
        
        long ans = 0;
        for (int i = 0; i <= 100000; i++) {
            if (count[i] > 0) {
                ans += (long) count[i] * i * i;
            }
        }
        
        return ans;
    }
}