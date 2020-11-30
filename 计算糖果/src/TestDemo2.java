import java.util.Scanner;

public class TestDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            int num1 = Integer.parseInt(split[0]);
            int num2 = Integer.parseInt(split[1]);
            int num3 = Integer.parseInt(split[2]);
            int num4 = Integer.parseInt(split[3]);
            int a = (num1 + num3) / 2;
            int b = (num2 + num4) / 2;
            int c = num4 - b;
            if (a - b == num1 && b - c == num2 && a + b == num3 && b + c == num4) {
                System.out.println(a + " " + b + " " + c);
            } else {
                System.out.println("No");
            }
        }
    }
}
