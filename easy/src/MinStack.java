import java.util.ArrayList;

/**
 * @Author szl
 * @Date 2021/8/26 11:43
 * @Description
 */
public class MinStack {
    ArrayList<Integer> stack;
    ArrayList<Integer> help;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new ArrayList<>();
        help = new ArrayList<>();
        help.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.add(val);
        help.add(Math.min(help.get(help.size() - 1), val));
    }

    public void pop() {
        stack.remove(stack.size() - 1);
        help.remove(help.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return help.get(help.size() - 1);
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
