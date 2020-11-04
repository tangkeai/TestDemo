import java.util.Stack;
/*
* 实现一个最小栈
* */
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        //1.stack是一定需要放元素的
        stack.push(x);
        //2.最小栈是否存放元素 想x<= 最小栈的栈顶元素
        //第一次放
        if (minStack.empty()) {
            minStack.push(x);
        }else if(x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        //1.stack一定需要弹出元素的
           stack.pop();
        //2.最小栈是否弹出元素 x==最小栈栈顶元素
        if (stack.pop() == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        //和最小栈没有关系
        return stack.peek();
    }

    public int getMin() {
        //每回返回最小栈的栈顶元素
        return minStack.peek();
    }
}
public class TestDemo3 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(2);
        minStack.push(1);
        minStack.push(5);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
    }
}
