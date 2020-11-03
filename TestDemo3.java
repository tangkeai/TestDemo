//顺序栈+ 链式队列
class Node {
    Node next;
    int val;
    public Node(int val) {
        this.val = val;
    }
}

class MyQueue {
    public Node head;
    public Node tail;

    //插入元素
    public void offer(int val) {
        Node node = new Node(val);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        this.tail = this.tail.next;
    }

    //查看栈顶元素并且删除该元素
    public int poll() {
        if (this.head == null) {
            throw new RuntimeException("队列为空！");
        }
        int oldData = this.head.val;
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        }else {
            this.head = this.head.next;
        }
        return oldData;
    }

    //查看栈顶元素
    public int peek() {
        if (this.head == null) {
            throw new RuntimeException("队列为空！");
        }
        return this.head.val;
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return head == null;
    }
}

public class TestDemo3 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
    }
}
