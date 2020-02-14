//Design an Iterator class, which has: 
//
// 
// A constructor that takes a string characters of sorted distinct lowercase Eng
//lish letters and a number combinationLength as arguments. 
// A function next() that returns the next combination of length combinationLeng
//th in lexicographical order. 
// A function hasNext() that returns True if and only if there exists a next com
//bination. 
// 
//
// 
//
// Example: 
//
// 
//CombinationIterator iterator = new CombinationIterator("abc", 2); // creates t
//he iterator.
//
//iterator.next(); // returns "ab"
//iterator.hasNext(); // returns true
//iterator.next(); // returns "ac"
//iterator.hasNext(); // returns true
//iterator.next(); // returns "bc"
//iterator.hasNext(); // returns false
// 
//
// 
// Constraints: 
//
// 
// 1 <= combinationLength <= characters.length <= 15 
// There will be at most 10^4 function calls per test. 
// It's guaranteed that all calls of the function next are valid. 
// 
// Related Topics Backtracking Design


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class CombinationIterator {
    private String characters;
    private int length;
    private LinkedList<LinkedList<Integer>> combinations;

    public CombinationIterator(String characters, int combinationLength) {
        combinations = new LinkedList<>();
        this.characters = characters;
        length = characters.length();
        backtrack(new LinkedList<>(), 0, combinationLength);
    }

    private void backtrack(LinkedList<Integer> tempList, int start, int k) {
        if (k == 0) {
            combinations.addLast(new LinkedList<>(tempList));
            return;
        }
        for (int i = start; i <= length - k; i++) {
            tempList.add(i);
            backtrack(tempList, i + 1, k - 1);
            tempList.removeLast();
        }
    }
    
    public String next() {
        StringBuilder sb = new StringBuilder();
        combinations.removeFirst().forEach(integer -> sb.append(characters.charAt(integer)));
        return sb.toString();
    }
    
    public boolean hasNext() {
        return !combinations.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)
