package hot100.第155题最小栈;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.add(Integer.MAX_VALUE);
    }

    /**
     * 将元素val推入堆栈
     * @param val
     */
    public void push(int val) {
        stack.addLast(val);
        minStack.addLast(val < minStack.getLast() ? val : minStack.getLast());
    }

    /**
     * 删除堆栈顶部元素
     */
    public void pop() {
        if (stack != null && stack.size() > 0 && minStack != null && minStack.size() > 1) {
            stack.pollLast();
            minStack.pollLast();
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minStack.getLast();
    }

    public static void main(String[] args) {
        MinStack minStack1 = new MinStack();
        minStack1.push(-2);
        minStack1.push(0);
        minStack1.push(-3);
        minStack1.getMin();
        minStack1.pop();
        minStack1.top();
        minStack1.getMin();
    }
}

