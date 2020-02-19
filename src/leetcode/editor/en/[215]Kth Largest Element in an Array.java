//Find the kth largest element in an unsorted array. Note that it is the kth lar
//gest element in the sorted order, not the kth distinct element. 
//
// Example 1: 
//
// 
//Input: [3,2,1,5,6,4] and k = 2
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: [3,2,3,1,2,4,5,5,6] and k = 4
//Output: 4 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ array's length. 
// Related Topics Divide and Conquer Heap


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        int mid = (start + end) / 2;
        int pivot = nums[mid];
        int left = start, right = end;
        //这里保证了end始终是pivot，swap时是--right而不是right--
        swap(nums, mid, end);
        while (left < right) {
            if (nums[left++] >= pivot) swap(nums, --left, --right);
        }
        //这时候把end处的pivot换到left的位置
        swap(nums, left, end);
        //pivot是第几大元素
        int m = end - left + 1;
        if (m == k) return pivot;
        //如果pivot过小，那么就在pivot右侧继续找
        if (m > k) return quickSelect(nums, left + 1, end, k);
        //如果pivot过大，那么就在pivot左侧找第k-m大的元素
        return quickSelect(nums, start, left - 1, k - m);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
