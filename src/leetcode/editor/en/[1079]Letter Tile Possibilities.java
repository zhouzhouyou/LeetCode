//You have a set of tiles, where each tile has one letter tiles[i] printed on it
//. Return the number of possible non-empty sequences of letters you can make. 
//
// 
//
// Example 1: 
//
// 
//Input: "AAB"
//Output: 8
//Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "AB
//A", "BAA".
// 
//
// 
// Example 2: 
//
// 
//Input: "AAABBC"
//Output: 188
// 
//
// 
// 
//
// Note: 
//
// 
// 1 <= tiles.length <= 7 
// tiles consists of uppercase English letters. 
// Related Topics Backtracking


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int count = 0;

    public int numTilePossibilities(String tiles) {
        char[] input = tiles.toCharArray();
        Arrays.sort(input);
        boolean[] visited = new boolean[input.length];
        dfs(input, 0, visited);
        return count;
    }

    private void dfs(char[] input, int k, boolean[] visited) {
        if (k == input.length) return;
        for (int i = 0; i < input.length; i++) {
            if (visited[i]) continue;
            if (i - 1 >= 0 && input[i-1] == input[i] && !visited[i-1]) continue;
            count++;
            visited[i] = true;
            dfs(input, k + 1, visited);
            visited[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
