import java.util.Scanner;

//最小公倍数  --   辗转相除法
public class TestDemo4 {
    public static int gcd(int a,int b) {
        if (a%b == 0) {
            return b;
        }else {
            return gcd(b,a%b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b= sc.nextInt();
            if (a ==0 || b == 0) {
                System.out.println(0);
            }else {
                System.out.println(a*b/gcd(a,b));
            }
        }
    }
}
