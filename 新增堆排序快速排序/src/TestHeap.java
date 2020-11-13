import java.util.Arrays;

//堆的底层是数组
public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void adjustDown(int parent , int len) {
        int child = 2*parent + 1;
        //是否有左孩子
        while (child < len) {
            //是否有右孩子 如果有 child保存左右孩子最大值下标
            if(child+1 < len && elem[child] < elem[child+1]) {
                child++;
            }
            if (elem[child] > elem[parent]) {
                int tmp = elem[parent];
                elem[parent] = elem[child];
                elem[child] = tmp;
                parent = child;
                child = 2*parent + 1;
            }else {
                break;
            }
        }
    }

    public void initHeap(int[] arry) {
        for (int i = 0; i < arry.length; i++) {
            this.elem[i] = arry[i];
            this.usedSize++;
        }
        //建堆的时间复杂度是O(n*logn)
        for (int i = (usedSize-1-1)/2; i >= 0 ; i--) {
            adjustDown(i,usedSize);//调整的时间复杂度是：O(logn)
        }
        System.out.println("=================");
    }

    public void adjustUp(int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if(elem[parent] < elem[child]) {
                int tmp = elem[parent];
                elem[parent] = elem[child];
                elem[child] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else  {
                break;
            }
        }
    }

    public void push(int val) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        this.elem[this.usedSize] = val;
        this.usedSize++;//11
        adjustUp(this.usedSize - 1);
        System.out.println("===============");
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    public void pop() {
        //0.判空
        if(isEmpty()) {
            return;
        }
        //1.交换堆顶元素和最后一个元素
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = tmp;
        this.usedSize--;
        adjustDown(0,this.usedSize);
        System.out.println("=========");
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public void heapSort() {
        int end = this.usedSize-1;
        while(end > 0) {
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            adjustDown(0,end);
            end--;
        }
    }

    public void show() {
        for (int i = 0; i < this.usedSize ; i++) {
            System.out.print(elem[i] +" ");
        }
    }
}
