import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestDemo1 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] array = str.split(" ");
            for (int i = 0; i < array.length ; i++) {
                if (!map.containsKey(array[i])) {
                    map.put(array[i],1);
                }else {
                    int val = map.get(array[i]);
                    if (val >= (array.length-1)/2) {
                        System.out.println(array[i]);
                        break;
                    }
                    map.put(array[i],val+1);
                }
            }
        }
    }
}
