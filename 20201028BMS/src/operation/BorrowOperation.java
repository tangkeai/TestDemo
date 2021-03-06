package operation;

import book.Book;
import book.BookList;

public class BorrowOperation implements IOperation {
    public void work(BookList bookList) {
        System.out.println("借阅图书");
        System.out.println("请输入要借阅的书籍！ ");
        String name = this.scan.next();
        int currentSized = bookList.getUsedsize();
        int i = 0;
        for (; i < currentSized; i++) {
            Book book = bookList.getBook(i);
            //boolean currentBorrowed = book.setBorrowed(book);
            if(book.getName().equals(name)) {
                //System.out.println(book);
                book.setBorrowed(true);
                System.out.println("借阅成功！ ");
                return;
            }
        }
        if(i == currentSized) {
            System.out.println("没有此书！ ");
            //return;
        }
    }
}
