class MyCircularQueue {
    public int[] elem;
    public int front;
    public int rear;

    MyCircularQueue(int k) {
        this.elem = new int[k];
    }

    //往循环队列中插元素
    public boolean enQueue(int value) {
        //循环队列为满
        if((this.rear+1)%elem.length == front) {
            return false;
        }
        this.elem[this.rear] = value;
        this.rear = (rear+1)%this.elem.length;
        return true;
    }

    //往循环队列删除元素
    public boolean deQueue() {
        //循环队列是否为空
        if(this.rear == this.front) {
            return false;
        }
        this.front = (this.front+1)%this.elem.length;
        return true;
    }

    //获取front位置的值
    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[this.front];
    }

    //获取rear位置的值
    public int rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = this.rear == 0 ? this.elem.length-1 : this.rear-1;
        return this.elem[index];
    }

    //判断是否为空
    public boolean isEmpty() {
        if (this.front == this.rear) {
            return true;
        }
        return false;
    }

    //判断是否为满
    public boolean isFull() {
        if ((this.rear+1)%elem.length == front) {
            return true;
        }
        return false;
    }
}

public class TestDemo4 {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(4);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        System.out.println(myCircularQueue.front());
        System.out.println(myCircularQueue.rear());
    }
}
