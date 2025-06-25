
import java.util.ArrayList;

public class StackLeetCode {
    private ArrayList<Integer> stack;
    private ArrayList<Integer> minStack;
    private int top;
    public StackLeetCode() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
        top = -1;
    }

    public void push(int val) {
        stack.add(val);
        if (minStack.isEmpty()) {
            minStack.add(val);
        } else {
            int minval = minStack.get(minStack.size()-1);
            minStack.add(Math.max(minval, val));
        }
        top++;
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.remove(top);
            minStack.remove(top);
            top--;
        }
    }

    public int top() {
        return stack.get(top); 
    }

    public int getMin() {
        return minStack.get(top);
    }

}
