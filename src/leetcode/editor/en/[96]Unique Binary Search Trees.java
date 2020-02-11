//Given n, how many structurally unique BST's (binary search trees) that store v
//alues 1 ... n? 
//
// Example: 
//
// 
//Input: 3
//Output: 5
//Explanation:
//Given n = 3, there are a total of 5 unique BST's:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics Dynamic Programming Tree


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        /*
        G(n)为长度为n的序列，可以构成多少种二叉树。其中，n为0或者1时，G(n) = 1
        假设存在F(i, n)， 其中1 <= i <= n, i代表二叉树root的位置，F为此条件下的二叉树的数量
        那么G(n) = F(1, n) + F(2, n) + ... + F(n, n)
        而F(i, n) = G(i-1) * G(n - i)
        所以G(n) = G(0) * G(n - 1) + G(1) * G(n-2) + ... + G(n-1) * G(0)
         */
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
