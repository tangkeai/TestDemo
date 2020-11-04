import java.util.Stack;
/*
 * 用栈来实现队列
 * */
class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /*Initialize your data structure here.*/
    public MyQueue() {
        s1 = new Stack(); // s1入
        s2 = new Stack(); // s2出
    }

    /*Push element x to the back of queue.*/
    public void push(int x) {
        s1.push(x);
    }

    /*Removes the element from in front of queue and returns that element.*/
    public int pop() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        if (!s2.empty()) {
            return s2.pop();
        }
        return -1;
    }

    /*Get the front element*/
    public int peek() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        if (!s2.empty()) {
            return s2.peek();
        }
        return -1;
    }

    /*Return whether the queue is empty.*/
    public boolean empty() {
        if(s1.empty() && s2.empty()) {
            return true;
        }
        return false;
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
    }
}
