//Given a directed, acyclic graph of N nodes. Find all possible paths from node 
//0 to node N-1, and return them in any order. 
//
// The graph is given as follows: the nodes are 0, 1, ..., graph.length - 1. gra
//ph[i] is a list of all nodes j for which the edge (i, j) exists. 
//
// 
//Example:
//Input: [[1,2], [3], [3], []] 
//Output: [[0,1,3],[0,2,3]] 
//Explanation: The graph looks like this:
//0--->1
//|    |
//v    v
//2--->3
//There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
// 
//
// Note: 
//
// 
// The number of nodes in the graph will be in the range [2, 15]. 
// You can print different paths in any order, but you should keep the order of 
//nodes inside one path. 
//


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lists = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        helper(lists, path, graph, 0);
        return lists;
    }

    private void helper(List<List<Integer>> lists, LinkedList<Integer> temp, int[][] graph, int cur) {
        if (graph[cur].length == 0) {
            lists.add(new LinkedList<>(temp));
            return;
        }
        for (int target : graph[cur]) {
            temp.add(target);
            helper(lists, temp, graph, target);
            temp.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
