
class GrayCode {
    public String[] getGray(int n) {
        //生成一个2^n个存储空间用于保存格雷码的种类
        String[] grayCode = new String[(int)Math.pow(2,n)];
        if (n == 1) {
            grayCode[0] = "0";
            grayCode[1] = "1";
            return grayCode;
        }
        //求取n-1 位的格雷码
        String[] last = getGray(n-1);

        for (int i = 0; i < last.length; i++) {
            grayCode[i] = "0" + last[i];
            grayCode[grayCode.length-1-i] = "1" + last[i];
        }
        return grayCode;
    }
}

public class TestGrayCode {
    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        String[] array = grayCode.getGray(2);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}