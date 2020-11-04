import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
    public String name;
    public String classes;
    public double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}


public class TestDemo5 {
    /*
     * 删除第一个字符串当中出现的第二个字符串中的字符
     * 例如：String str1 = "welcome to bit"
     *      String str2 = "come"
     *      输出结果为wl t bit
     * */
    public static List<String> func(String str1,String str2) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
              char tmp = str1.charAt(i);
              //contains方法传入的参数为CharSequence s
              if(!str2.contains(tmp+"")) {
                  list.add(tmp + "");
              }
        }
        return list;
    }

    public static void main(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        List<String> ret = func(str1,str2);
        //System.out.println(ret);//打印结果[w, l,  , t,  , b, i, t]
        for (String str : ret) {
            System.out.print(str);//打印结果wl t bit
        }
    }

    public static void main2(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(2);
        Collections.sort(list);
        System.out.println(list);

    }

    /*
    * 学生对象放在List中，每个学生有姓名，班级，成绩属性
    * 遍历list集合，并把学生对象的属性打印出来
    * */
    public static void main1(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三", "计算机1班", 98));
        list.add(new Student("李四","计算机2班",92));
        list.add(new Student("王五","计算机3班",99));

        for (Student student : list) {
            System.out.println(student);
        }
    }
}
