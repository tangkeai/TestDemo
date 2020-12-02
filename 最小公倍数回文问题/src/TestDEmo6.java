//有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。

//给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。

public class TestDEmo6 {

    public static boolean isPalindrome(int x)  {
        if (x < 0 || (x%10 == 0 && x!= 0)) {
            return false;
        }
        //12321
        int revertedNum = 0;
        while (x > revertedNum ) {
            revertedNum = revertedNum*10 + x%10;
            x /= 10;
        }
        return x == revertedNum || x == revertedNum/10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }
}
