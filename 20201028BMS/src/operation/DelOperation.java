package operation;

import book.Book;
import book.BookList;

public class DelOperation implements IOperation {
    public void work(BookList bookList) {
        System.out.println("删除图书");
        System.out.println("请输入要删除书的名字：");
        String name = this.scan.next();
        int currentSized = bookList.getUsedsize();
        Book tmp = null;
        int i = 0;
        for (; i < currentSized; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)) {
                for (int j = i; j < currentSized; j++) {
                    //bookList.getBook(j);
                    book = bookList.getBook(j + 1);
                    bookList.setBook(j, book);
                }
                bookList.setUsedsize(currentSized-1);
                System.out.println("删除成功！ ");
                return;
            }
        }
        if(i == currentSized) {
            System.out.println("此书不存在");
        }
    }
}
