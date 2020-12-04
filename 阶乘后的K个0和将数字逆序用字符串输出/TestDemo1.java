import java.util.Scanner;
// 阶乘后的零
//给定一个整数 n，返回 n! 结果尾数中零的数量。
public class TestDemo1 {
    public static Long func(int num) {
        if (num == 0) {
            return 1L;
        }
        return num * func(num -1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int  n = sc.nextInt();
            Long  num = func(n);
            int count = 0;
            while (num%10 == 0) {
                num = num/10;
                count++;
            }
            System.out.println(count);//100
        }
    }
}
