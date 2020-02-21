//There are n people whose IDs go from 0 to n - 1 and each person belongs exactl
//y to one group. Given the array groupSizes of length n telling the group size ea
//ch person belongs to, return the groups there are and the people's IDs each grou
//p includes. 
//
// You can return any solution in any order and the same applies for IDs. Also, 
//it is guaranteed that there exists at least one solution. 
//
// 
// Example 1: 
//
// 
//Input: groupSizes = [3,3,3,3,3,1,3]
//Output: [[5],[0,1,2],[3,4,6]]
//Explanation: 
//Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
// 
//
// Example 2: 
//
// 
//Input: groupSizes = [2,1,3,3,3,2]
//Output: [[1],[0,5],[2,3,4]]
// 
//
// 
// Constraints: 
//
// 
// groupSizes.length == n 
// 1 <= n <= 500 
// 1 <= groupSizes[i] <= n 
// 
// Related Topics Greedy


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static class Node {
        int capacity;
        List<Integer> list = new LinkedList<>();
        Node next;

        Node(int capacity) {
            this.capacity = capacity;
        }

        void add(int num) {
            if (list.size() < capacity) list.add(num);
            else {
                if (next == null) next = new Node(capacity);
                next.add(num);
            }
        }

        void iter(List<List<Integer>> lists) {
            lists.add(list);
            if (next != null) next.iter(lists);
        }
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (!map.containsKey(size)) map.put(size, new Node(size));
            map.get(size).add(i);
        }
        map.values().forEach(node -> node.iter(lists));
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
