import java.util.Scanner;

class Solution {
    public int preimageSizeFZF(long K) {
        long left = 0;
        long right = 5L*(K+1);
        while (left < right) {
            long mid = (left+right)/2;
            int num = numOfTrailingZero(mid);
            if (num == K) {
                return 5;
            }else if (num < K) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public int numOfTrailingZero(long n) {
        int sum = 0;
        while (n != 0) {
            n = n / 5;
            sum += n;
        }
        return sum;
    }
}

public class TestDemo5 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            long K = sc.nextInt();
            System.out.println(solution.preimageSizeFZF(K));
        }
    }
}