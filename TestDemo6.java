import java.util.ArrayList;
import java.util.List;

/*
* 杨辉三角
* */
class Soluction {
    public List<List<Integer>> generate(int numRow) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRow == 0) {
            return ret;
        }
        //第一行
        List<Integer> one = new ArrayList<>();
        one.add(1);
        ret.add(one);
        //从第2行开始放
        for (int i = 1; i < numRow ; i++) {
            //每一行进来，都要一个 list curRow
            List<Integer> curRow = new ArrayList<>();
            //当前行的第0列 放一个1
            curRow.add(1);
            //前一行
            List<Integer> preRow = ret.get(i-1);
            for (int j = 1; j < i; j++) {
                int tmp = preRow.get(j-1) + preRow.get(j);
                curRow.add(tmp);
            }
            curRow.add(1);
            //当前行都添加完了
            ret.add(curRow);
        }
        return ret;
    }
}
public class TestDemo6 {
    public static void main(String[] args) {
        Soluction soluction = new Soluction();
        List<List<Integer>> rst = soluction.generate(4);
        System.out.println(rst);
    }
}
