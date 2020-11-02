package operation;

import book.Book;
import book.BookList;

public class ReturnOperation implements IOperation {
    public void work(BookList bookList) {
        System.out.println("归还图书");
        System.out.println("请输入要归还书的名字：");
        String name = this.scan.next();
        int currentSized = bookList.getUsedsize();
        int i = 0;
        for (; i < currentSized; i++) {
            Book book = bookList.getBook(i);
            //boolean currentBorrowed = book.setBorrowed(book);
            if(book.getName().equals(name)) {
                //System.out.println(book);
                book.setBorrowed(false);
                System.out.println("归还成功！ ");
                return;
            }
        }
        if(i == currentSized) {
            System.out.println("没有此书，归还失败！ ");
        }
    }
}
