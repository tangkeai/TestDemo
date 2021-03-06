import java.util.Arrays;
import java.util.Random;

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

    public static void main(String[] args) {
        //int[] arry = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
        int[] arry = new int[10_0000];
        Random random = new Random();
        for (int i = 0; i < arry.length; i++) {
            arry[i] = random.nextInt(10_0000);
        }
        //System.out.println(Arrays.toString(arry));
        //selectSort(arry);
        //shellSort(arry);
        selectSort(arry);

        //System.out.println(Arrays.toString(arry));
        /*shellSort(arry);
        System.out.println(Arrays.toString(arry));*/
    }
}
