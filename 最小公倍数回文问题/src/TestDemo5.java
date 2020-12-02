import java.util.Scanner;

/**
 * 判断回文:这里我们首先将用户输入的字符串变为一个个的char，
 * 一个指针从开头向后遍历每个char的同时另一个指针从后向前遍历，当发现字符不相等时说明不是回文串。
 * 查找插入位置:知道如何判断回文后我们只需要将第二个字符串从第一个字符串第一个位置
 * 开始尝试插入直到判断回文的方法返回true时即找到插入位置
 */
public class TestDemo5 {
    public static boolean isHuoWen(String s1) {
        int j = s1.length() - 1;
        int i = 0;
        while (i < j) {
            if (s1.charAt(i) != s1.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int count = 0;
        for (int i = 0; i <= s1.length(); i++) {
            StringBuilder sb = new StringBuilder(s1);
            sb.insert(i,s2);
            if (isHuoWen(sb.toString())) {
                count++;
            }
        }
        System.out.println(count);
    }
}
