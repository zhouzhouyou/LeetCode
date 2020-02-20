//Median is the middle value in an ordered integer list. If the size of the list
// is even, there is no middle value. So the median is the mean of the two middle 
//value. 
//For example,
//
// [2,3,4], the median is 3 
//
// [2,3], the median is (2 + 3) / 2 = 2.5 
//
// Design a data structure that supports the following two operations: 
//
// 
// void addNum(int num) - Add a integer number from the data stream to the data 
//structure. 
// double findMedian() - Return the median of all elements so far. 
// 
//
// 
//
// Example: 
//
// 
//addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2
// 
//
// 
//
// Follow up: 
//
// 
// If all integer numbers from the stream are between 0 and 100, how would you o
//ptimize it? 
// If 99% of all integer numbers from the stream are between 0 and 100, how woul
//d you optimize it? 
// 
// Related Topics Heap Design


import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    private PriorityQueue<Integer> minH;
    private PriorityQueue<Integer> maxH;

    /** initialize your data structure here. */
    public MedianFinder() {
        minH = new PriorityQueue<>();
        maxH = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
    }
    
    public void addNum(int num) {
        maxH.add(num);
        minH.add(maxH.poll());
        //每次先把大顶堆的最大值放到小顶堆的最下面
        if (minH.size() > maxH.size()) maxH.add(minH.poll());
        //然后把小顶堆的最小值扔到大顶堆的最下面
        //这样可以保证
    }
    
    public double findMedian() {
        if (minH.size() == maxH.size()) {
            return (double)(maxH.peek() + minH.peek()) * 0.5;
        }
        return maxH.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
