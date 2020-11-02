package operation;

import book.Book;
import book.BookList;

public class FindOperation implements IOperation {
    public void work(BookList bookList) {
        System.out.println("查找图书");
        System.out.println("请输入要查找的书籍！ ");
        String name = this.scan.next();
        int currentSized = bookList.getUsedsize();
        int i = 0;
        for (; i < currentSized; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)) {
                System.out.println(book);
                break;
            }
        }
        if(i == currentSized) {
            System.out.println("没有此书！ ");
        }
    }
}
