package book;

public class BookList {

    private Book[] elem = new Book[10];
    private int usedsize;
    public BookList() {
        this.elem[0] = new Book("三国演义","罗贯中",30,"小说");
        this.elem[1] = new Book("西游记","吴承恩",25,"小说");
        this.elem[2] = new Book("Java编程思想","比特",89,"学习");
        this.usedsize = 3;
    }

    //尾插
    public void setBook(int pos,Book book) {
        this.elem[pos] = book;
    }

    public Book getBook(int pos) {
        return this.elem[pos];
    }
    public int getUsedsize() {
        return usedsize;
    }
    public void setUsedsize(int usedsize) {
        this.usedsize = usedsize;
    }
}
