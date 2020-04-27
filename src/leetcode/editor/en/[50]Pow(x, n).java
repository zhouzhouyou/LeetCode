//Implement pow(x, n), which calculates x raised to the power n (xn). 
//
// Example 1: 
//
// 
//Input: 2.00000, 10
//Output: 1024.00000
// 
//
// Example 2: 
//
// 
//Input: 2.10000, 3
//Output: 9.26100
// 
//
// Example 3: 
//
// 
//Input: 2.00000, -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
// 
//
// Note: 
//
// 
// -100.0 < x < 100.0 
// n is a 32-bit signed integer, within the range [−231, 231 − 1] 
// 
// Related Topics Math Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        double mul = 1;
        if (n > 0) {
            mul = powIteration(x, n);
        } else {
            //单独考虑 n = -2147483648
            if (n == -2147483648) {
                return myPow(x, -2147483647) * (1 / x);
            }
            n = -n;
            mul *= powIteration(x, n);
            mul = 1 / mul;
        }
        return mul;
    }

    public double powIteration(double x, int n) {
        double ans = 1;
        //遍历每一位
        while (n > 0) {
            //最后一位是 1，加到累乘结果里
            if ((n & 1) == 1) {
                ans *= x;
            }
            //更新 x
            x *= x;
            //n 右移一位
            n >>= 1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
