import book.BookList;
import operation.IOperation;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Main {

    //登录
    public static User login() {
        System.out.println("请输入你的姓名: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("请输入你的身份，0是普通用户，1是管理员");
        int choice = scanner.nextInt();
        if (choice == 0) {
            //发生向上转型
            return new NormalUser(name);
        }else {
            //发生向上转型
            return new Admin(name);
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();//向上转型

        while (true) {
            int choice = user.menu();//1
            //直接访问不到IOperation
            // 所以在User.java提供一个公开的接口doOperation
            IOperation iOperation = user.doOperation(choice);
            iOperation.work(bookList);
        }

    }
}
