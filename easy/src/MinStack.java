import java.util.ArrayList;

/**
 * @Author szl
 * @Date 2021/8/26 11:43
 * @Description
 */
public class MinStack {
    int min = Integer.MAX_VALUE;
    ArrayList<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        min = Math.min(val, min);
        stack.add(val);
    }

    public void pop() {
        stack.remove(stack.size() - 1);
        min = Integer.MAX_VALUE;
        System.out.println(stack);
        for (Integer integer : stack) {
            min = Math.min(min, integer);
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
