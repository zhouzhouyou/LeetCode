//Given an array A of non-negative integers, return an array consisting of all t
//he even elements of A, followed by all the odd elements of A. 
//
// You may return any answer array that satisfies this condition. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: [3,1,2,4]
//Output: [2,4,3,1]
//The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
// 
//
// 
//
// Note: 
//
// 
// 1 <= A.length <= 5000 
// 0 <= A[i] <= 5000 
// 
// 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            if ((A[left++] & 1) != 0) {
                int temp = A[right];
                A[right--] = A[--left];
                A[left] = temp;
            }
        }
        return A;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
