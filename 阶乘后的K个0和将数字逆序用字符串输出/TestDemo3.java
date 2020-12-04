import java.util.Scanner;
//数字逆序为字符串输出
public class TestDemo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] array = s.toCharArray();
        char tmp = array[0];
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k]);
        }
    }
}
