package sample;

import file_scan.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;

import java.io.File;
import java.util.Random;

public class Controller {

    @FXML
    public TextField inputFiled;

    @FXML
    public Label outputLabel;

    @FXML
    public TableView<Student> tableView;
    public GridPane rootGridPane;

    Random random = new Random(20200118);
    private int id = 1;
    private final String[] GENGERS = {"女","男"};
    private void addStudent(String name) {
        int age = random.nextInt(50)+20;
        String gender = GENGERS[random.nextInt(2)];
        Student student = new Student(id++,name,age,gender);

        ObservableList<Student> items = tableView.getItems();
        items.add(student);
        System.out.println(student);
    }

    @FXML
    public void 点击事件(MouseEvent mouseEvent) {
        String inputText = inputFiled.getText();
        System.out.println(inputText);
        addStudent(inputText);
        outputLabel.setText(inputText);
    }

    private Thread scanThread = null;
    @FXML
    public void 选择文件夹(MouseEvent mouseEvent) {
        DirectoryChooser chooser = new DirectoryChooser();
        Window window = rootGridPane.getScene().getWindow();
        File root = chooser.showDialog(window);
        System.out.println(root);
        if (root == null) {
            return;
        }
        scanThread = new Thread(()-> {
            //Main.traversalDepth(root);//运行时间的边界是否明确——有可能运行时间过长
            //把结果放在表里
        });
        //Daemon——精灵
        //默默守护——后台线程
        scanThread.setDaemon(true);//设置为后台线程
        //主线程和创建的线程都是前台线程， 一个程序的所有前台线程都推出才可以
        //JVM退出条件：所有前台线程都退掉
        //点击X的时候，只退掉了主线程
        scanThread.start();
    }
}
