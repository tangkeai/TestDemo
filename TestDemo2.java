//栈
class MyStack {
    public int[] elem;
    public int usedSize;

    public MyStack() {
        this.elem = new int[5];
    }
    public void push(int item) {
        if (isFull()) {
            return;
        }
        this.elem[this.usedSize] = item;
        this.usedSize++;
    }
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        this.usedSize--;
        return this.elem[usedSize];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        return this.elem[usedSize-1];
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(12);
        myStack.push(3);

        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
    }
}
