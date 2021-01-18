package file_scan;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        File root = new File("D:\\JAVA学习\\JAVA课件");

        //traversalDepth(root);
        //traversalBroadcast(root);
        //打印root的子路径
        /*String[] list = root.list();
        System.out.println(Arrays.toString(list));*///[Controller.java, Main.java, sample.fxml]
        //File[] files = root.listFiles();
        //System.out.println(Arrays.toString(files));//[D:\JAVA学习\JAVA课件\上课代码\本地搜索工具预研1-20210117\Controller.java, D:\JAVA学习\JAVA课件\上课代码\本地搜索工具预研1-20210117\Main.java, D:\JAVA学习\JAVA课件\上课代码\本地搜索工具预研1-20210117\sample.fxml]

//        File[] files = root.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                if (name.endsWith(".fxml")) {
//                    return true;
//                }else {
//                    return false;
//                }
//            }
//        });
//        System.out.println(Arrays.toString(files));
    }

    //广度优先——层序遍历——队列
    public static void traversalBroadcast(File root) {
        //无论是普通文件还是文件夹都放入队列中
        Queue<File> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            File file = queue.poll();
            boolean directory = root.isDirectory();
            if (directory) {
                System.out.println("文件夹：" +file);
            }else {
                System.out.println("普通问价："+file);
            }
            File[] files = file.listFiles();
            if (files == null) {
                continue;
            }
            if (files.length == 0) {
                continue;
            }

            for (File child:files) {
                queue.offer(child);
            }
        }
    }

    //深度优先遍历——栈——递归
    public static void traversalDepth(File root) {
        System.out.println("文件夹："+root);
        File[] files = root.listFiles();

        //判断是不是叶子节点
        if (files == null) {
            return;
        }

        //判断结束

        //针对每个孩子，进行递归处理
        //只处理文件夹即可
        if (files.length == 0) {
            return;
        }

        for (File file:files) {
            if (!file.isDirectory()) {
                System.out.println("普通文件："+file);
                continue;
            }
            traversalDepth(file);
        }
    }
}
