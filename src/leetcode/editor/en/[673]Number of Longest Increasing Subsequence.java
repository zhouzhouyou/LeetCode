//
//Given an unsorted array of integers, find the number of longest increasing sub
//sequence.
// 
//
// Example 1: 
// 
//Input: [1,3,5,4,7]
//Output: 2
//Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3
//, 5, 7].
// 
// 
//
// Example 2: 
// 
//Input: [2,2,2,2,2]
//Output: 5
//Explanation: The length of longest continuous increasing subsequence is 1, and
// there are 5 subsequences' length is 1, so output 5.
// 
// 
//
// Note:
//Length of the given array will be not exceed 2000 and the answer is guaranteed
// to be fit in 32-bit signed int.
// Related Topics Dynamic Programming


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
        int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
        Arrays.fill(counts, 1);

        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < j; ++i)
                if (nums[i] < nums[j]) {
                    if (lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                    } else if (lengths[i] + 1 == lengths[j]) {
                        counts[j] += counts[i];
                    }
                }
        }

        int longest = 0, ans = 0;
        for (int length : lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < N; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
