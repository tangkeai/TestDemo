import java.util.PriorityQueue;

public class TestDemo {

    public static void main(String[] args) {
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        TestHeap testHeap = new TestHeap();
        testHeap.initHeap(arr);
        System.out.println("===================");
        testHeap.heapSort();
        testHeap.show();
        System.out.println("===================");
    }

    public static void main1(String[] args) {
        int[] arr = {4,1,9,2,8,0,7,3,6,5};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(arr.length);
        priorityQueue.offer(13);
        priorityQueue.offer(3);
        priorityQueue.offer(8);
        priorityQueue.offer(49);
        priorityQueue.offer(null);
        /*for (int e: arr) {
            priorityQueue.offer(e);
            System.out.print(priorityQueue.poll()+"");
        }

        System.out.println(priorityQueue.size());*/
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());

    }
}
