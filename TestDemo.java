import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("悟能","猪八戒");
        map.put("齐天大圣","孙悟空");
        System.out.println(map);
        System.out.println(map.get("悟能"));
        System.out.println(map.getOrDefault("玄奘", "唐僧"));

        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        for (Map.Entry<String,String> entry: entrySet) {
            System.out.println(entry.getKey() +"=" +entry.getValue());
        }
    }
    
    public static void main1(String[] args) {
        Collection<Integer> collection1 = new ArrayList<>();
        collection1.add(1);
        collection1.add(1);
        collection1.add(2);
        collection1.remove(1);
        System.out.println(collection1);
        System.out.println(collection1.isEmpty());

        Collection<String> collection2 = new LinkedList<>();
        collection2.add("hello");
    }
}
