//Design a stack that supports push, pop, top, and retrieving the minimum elemen
//t in constant time. 
//
// 
// push(x) -- Push element x onto stack. 
// pop() -- Removes the element on top of the stack. 
// top() -- Get the top element. 
// getMin() -- Retrieve the minimum element in the stack. 
// 
//
// 
//
// Example: 
//
// 
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> Returns -3.
//minStack.pop();
//minStack.top();      --> Returns 0.
//minStack.getMin();   --> Returns -2.
// 
//
// 
// Related Topics Stack Design


//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Node fake;
    int min = Integer.MAX_VALUE;

    private class Node {
        int val;
        Node next = null;

        Node() {

        }

        Node(int val) {
            this.val = val;
        }
    }

    private int sPop() {
        Node head = fake.next;
        fake.next = head.next;
        return head.val;
    }

    private void sPush(int x) {
        Node head = new Node(x);
        head.next = fake.next;
        fake.next = head;
    }

    /** initialize your data structure here. */
    public MinStack() {
        fake = new Node();
    }
    
    public void push(int x) {
        if (x <= min) {
            sPush(min);
            min = x;
        }
        sPush(x);
    }
    
    public void pop() {
        if (sPop() == min) {
            min = sPop();
        }
    }
    
    public int top() {
        if (fake.next == null) return min;
        return fake.next.val;
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
