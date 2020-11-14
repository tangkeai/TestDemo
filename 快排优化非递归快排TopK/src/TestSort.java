import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * 插入排序
 *稳定性：稳定
 *时间复杂度：
 *         最好情况下：O(N)    数组中的数据是有序的
 *         最坏的情况下：O(N^2)  数组中的数据是无序的
 * 空间复杂度：O(1)
 * 特点：越有序 越快
 */
public class TestSort {
    public static void insertSort(int[] arry) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < arry.length; i++) {
            int tmp = arry[i];
            int j = i-1;
            for (; j >= 0 ; j--) {
                if(arry[j] > tmp) {
                    arry[j+1] = arry[j];
                }else {
                    //arry[j+1] = tmp;
                    break;
                }
            }
            arry[j+1] = tmp;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    /**
     * 希尔排序
     * 稳定性：不稳定排序
     * 时间复杂度：O(n^1.3)  -   O(n^1.5)
     * 空间复杂度:O(1)
     */
    public static void shell(int[] arry,int gap) {
        long start = System.currentTimeMillis();
        for (int i = gap; i < arry.length; i++) {
            int tmp = arry[i];
            int j = i-gap;
            for (; j >= 0; j-=gap) {
                if(arry[j] > tmp) {
                    arry[j+gap] = arry[j];
                }else {
                    break;
                }
            }
            arry[j+gap] = tmp;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void shellSort(int[] arry) {
        int[] ddr = {5,3,1};
        for (int i = 0; i < ddr.length; i++) {
            shell(arry,ddr[i]);
        }
    }

    /**
     *选择排序
     * 稳定性：不稳定
     * 时间复杂度：O(n^2)
     * 空间复杂度:O(1)
     * @param arry
     */
    public static void selectSort(int[] arry) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arry.length; i++) {
            for (int j = i+1; j < arry.length; j++) {
                int tmp = arry[i];
                if(tmp > arry[j]) {
                    arry[i] = arry[j];
                    arry[j] = tmp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void adjustDown(int[] arry, int parent, int len) {
        //有左孩子
        int child = 2*parent + 1;
        while(child < len) {
            //有右孩子
            if (child+1 < len && arry[child] < arry[child+1]) {
                child++;
            }
            if(arry[child] > arry[parent]) {
                int tmp = arry[child];
                arry[child] = arry[parent];
                arry[parent] = tmp;
                parent = child;
                child = 2*parent + 1;
            }else {
                break;
            }
        }
    }

    public static void createHeap(int[] arry) {
        for (int i = (arry.length-1-1)/2; i >= 0 ; i--) {
            adjustDown(arry,i,arry.length);
        }
    }

    public static void heapSort(int[] arry) {
        //建堆  --->  大根堆
        createHeap(arry);
        int end = arry.length - 1;
        while(end > 0) {
            int tmp = arry[0];
            arry[0] = arry[end];
            arry[end] = tmp;
            adjustDown(arry,0,end);
            end--;
        }
    }

    public static int partion(int[] arry, int start, int end) {
        int tmp = arry[start];
        while (start < end) {
            while (start < end && arry[end] > tmp) {
                end--;
            }
            if(start >= end) {
                arry[start] = tmp;
            }else {
                arry[start] = arry[end];
            }
            while (start < end && arry[start] < tmp) {
                start++;
            }
            if(start >= end) {
                arry[start] = tmp;
            }else {
                arry[end] = arry[start];
            }
        }
        return start;
    }


        public static void insertSort2(int[] arry,int low , int high) {
            for (int i = low+1; i <= high; i++) {
                int tmp = arry[i];
                int j = i - 1;
                for (; j >= low; j--) {
                    if (arry[j] > tmp) {
                        arry[j + 1] = arry[j];
                    } else {
                        break;
                    }
                }
                arry[j + 1] = tmp;
            }
        }


        /**
     * 快速排序
     * 稳定性：不稳定
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(logn)
     * @param arry
     * @param low
     * @param high
     */
        
    public static void quick(int[] arry,int low,int high) {
        if(low >= high) {
            return;
        }

        //1.  优化    当low  high  之间的数据个数     小于某个值的时候    使用插入排序
        if(high-low+1 <= 100) {
            insertSort2(arry,low,high);
            return;
        }
        //2.  优化  三数取中法
        medianofThree(arry,low,high);
        int par = partion(arry,low,high);
        quick(arry,low,par-1);
        quick(arry,par+1,high);
    }

    public static void quickSort(int[] arry) {
        //quick(arry,0,arry.length-1);
        quilckNor(arry,0,arry.length-1);
    }

    /**
     * 非递归实现快排
     * @param arry
     * @param low
     * @param high
     */
    public static void quilckNor(int[] arry, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        //找基准
        int par = partion(arry,low,high);
        //基准左边至少有两个元素  0 1 2(基准)
        if(low+1 < par) {
            //将基准左边两端元素入栈
            stack.push(low);
            stack.push(par-1);
        }
        if(high-1 > par) {
            //将基准右边两端元素入栈
            stack.push(par+1);
            stack.push(high);
        }
        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();
            par = partion(arry,low,high);
            //基准左边至少有两个元素  0 1 2(基准)
            if(low+1 < par) {
                //将基准左边两端元素入栈
                stack.push(low);
                stack.push(par-1);
            }
            if(high-1 > par) {
                //将基准右边两端元素入栈
                stack.push(par+1);
                stack.push(high);
            }
        }
    }

    public static void swap(int[] arry, int low, int high) {
        int tmp = arry[low];
        arry[low] = arry[high];
        arry[high] = tmp;
    }

    public static void medianofThree(int[] arry,int low, int high) {
        int mid = (low+high)/2;
        //arry[mid] < arry[low] < arry[high]
        if(arry[low] >= arry[high]) {
            swap(arry,low,high);
        }
        if(arry[low] <= arry[mid]) {
            swap(arry,low,mid);
        }
        if(arry[mid] >= arry[high]) {
            swap(arry,mid,high);
        }

    }

    public static void main(String[] args) {
        int[] arry = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
        /*int[] arry = new int[10_0000];
        Random random = new Random();
        for (int i = 0; i < arry.length; i++) {
            arry[i] = random.nextInt(10_0000);
        }*/
        //System.out.println(Arrays.toString(arry));
        //selectSort(arry);
        //shellSort(arry);
        quickSort(arry);
        System.out.println(Arrays.toString(arry));
        //selectSort(arry);
        //System.out.println(Arrays.toString(arry));
        /*shellSort(arry);
        System.out.println(Arrays.toString(arry));*/
    }
}
