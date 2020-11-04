import java.util.LinkedList;
import java.util.Queue;

/*
* 两个队列实现栈
* */
class MyStack {
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;
    private int usedSize;

    /*Initialize your data structure here.*/
    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    /*push element x into stack*/
    public void push(int x) {
        //1.谁不为空  入到哪个队列就好了
        //2.两个都为空 放到第一个qu1当中
        if (!qu1.isEmpty()) {
            qu1.offer(x);
        }else if(!qu2.isEmpty()) {
            qu2.offer(x);
        }else {
            qu1.offer(x);
        }
        usedSize++;
    }

    /*Remove the element on top of the stack and return that element*/
    public int pop() {
        if (empty()) {
            return -1;
        }
        int size = usedSize;
        if (!qu1.isEmpty()) {
            for (int i = 0; i < size-1; i++) {
                qu2.offer(qu1.poll());
            }
            usedSize--;
            return qu1.poll();
        }else {
            for (int i = 0; i < size-1; i++) {
                qu1.offer(qu2.poll());
            }
            usedSize--;
            return qu2.poll();
        }

    }

    /*return whether the stack is empty.*/
    public boolean empty() {
        if (qu1.isEmpty() && qu2.isEmpty()) {
            return true;
        }
        return false;
    }

    /**get the top element*/
    public int top() {
        if(empty()) {
            return -1;
        }
        int size = usedSize;
        int tmp = -1;
        if (!qu1.isEmpty()) {
            for (int i = 0; i < size; i++) {
                tmp = qu1.poll();
                qu2.offer(tmp);
            }
        }else {
            for (int i = 0; i < size; i++) {
                tmp = qu2.poll();
                qu1.offer(tmp);
            }
        }
        return tmp;
    }
}

public class TestDemo1 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
    }
}
