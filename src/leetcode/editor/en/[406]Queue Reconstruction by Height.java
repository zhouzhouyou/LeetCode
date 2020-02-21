//Suppose you have a random list of people standing in a queue. Each person is d
//escribed by a pair of integers (h, k), where h is the height of the person and k
// is the number of people in front of this person who have a height greater than 
//or equal to h. Write an algorithm to reconstruct the queue. 
//
// Note: 
//The number of people is less than 1,100. 
// 
//
// Example 
//
// 
//Input:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//Output:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
//
// 
// Related Topics Greedy


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? -o1[0] + o2[0] : o1[1] - o2[1]);
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) list.add(p[1], p);
        return list.toArray(new int[people.length][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
