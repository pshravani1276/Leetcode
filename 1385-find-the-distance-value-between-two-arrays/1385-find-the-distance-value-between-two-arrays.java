class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        java.util.Arrays.sort(arr2);
        int distanceValue = 0;
        
        for (int v : arr1) {
            if (isValid(arr2, v, d)) {
                distanceValue++;
            }
        }
        
        return distanceValue;
    }
    
    private boolean isValid(int[] arr, int target, int d) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (Math.abs(arr[mid] - target) <= d) {
                return false;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return true;
    }
}