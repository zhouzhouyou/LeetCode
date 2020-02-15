//Count the number of prime numbers less than a non-negative number, n. 
//
// Example: 
//
// 
//Input: 10
//Output: 4
//Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
// 
// Related Topics Hash Table Math


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        boolean[] f = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (f[i]) continue;
            count++;
            for (int j = 2 * i; j < n; j += i) f[j] = true;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
