//Given a non-empty array of integers, return the k most frequent elements. 
//
// Example 1: 
//
// 
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1] 
// 
//
// Note: 
//
// 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements. 
// Your algorithm's time complexity must be better than O(n log n), where n is t
//he array's size. 
// 
// Related Topics Hash Table Heap


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static class Pair {
        public int num;
        public int freq;

        private Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Pair> list = new ArrayList<>();
        map.keySet().forEach(integer -> list.add(new Pair(integer, map.get(integer))));
        list.sort((o1, o2) -> - o1.freq + o2.freq);
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < k; i++) ans.add(list.get(i).num);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
