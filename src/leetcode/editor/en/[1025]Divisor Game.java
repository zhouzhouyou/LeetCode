//Alice and Bob take turns playing a game, with Alice starting first. 
//
// Initially, there is a number N on the chalkboard. On each player's turn, that
// player makes a move consisting of: 
//
// 
// Choosing any x with 0 < x < N and N % x == 0. 
// Replacing the number N on the chalkboard with N - x. 
// 
//
// Also, if a player cannot make a move, they lose the game. 
//
// Return True if and only if Alice wins the game, assuming both players play op
//timally. 
//
// 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: 2
//Output: true
//Explanation: Alice chooses 1, and Bob has no more moves.
// 
//
// 
// Example 2: 
//
// 
//Input: 3
//Output: false
//Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
// 
//
// 
//
// Note: 
//
// 
// 1 <= N <= 1000 
// 
// 
// Related Topics Math Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean divisorGame(int N) {
        //if divisorGame(N-1) = false, then divisorGame(N) = true.
        //Because the first can minus one to make it a divisorGame(N-1) for enemy.
        //for any odd number, it has only odd factor, so after the first move,
        //it will become an even number
        return N % 2 == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
