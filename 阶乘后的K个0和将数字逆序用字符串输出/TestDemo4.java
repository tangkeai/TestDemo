import java.util.Scanner;
// (优化)阶乘后的零
//给定一个整数 n，返回 n! 结果尾数中零的数量。
public class TestDemo4 {
    public static int func(int n) {
        int sum = 0;
        while (n != 0) {
            n = n / 5;
            sum += n;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(func(n));
        }
    }
}
