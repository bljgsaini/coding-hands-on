package javaPractice.concurrency;

public class WaitNotifyAndNotifyAllExample {
    public static void main(String[] args) {

        Book itHappensForAReason = new Book("It Happens for a Reason");

        BookReader bookReader1 = new BookReader(itHappensForAReason);
        BookReader bookReader2 = new BookReader(itHappensForAReason);

        Thread threadBenny = new Thread(bookReader1, "Benny");
        Thread threadZack = new Thread(bookReader2, "Zack");

        threadBenny.start();
        threadZack.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BookWriter bookWriter = new BookWriter(itHappensForAReason);
        Thread writerThread = new Thread(bookWriter, "writer");
        writerThread.start();

    }
}


class Book{
    String title;
    boolean isCompleted;

    public Book(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}


class BookReader implements Runnable{

    Book book;

    public BookReader(Book book){
        this.book = book;
    }

    @Override
    public void run() {
        synchronized (book){
            while(!book.isCompleted()){
                System.out.println("Thread name : " + Thread.currentThread().getName() + " Book : " + book.getTitle() + " is not finished yet! Please wait");
                try {
                    book.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread name : " + Thread.currentThread().getName() +  "Book : " + book.getTitle() + "finished reading." );
        }
    }
}


class BookWriter implements Runnable{

    Book book;

    public BookWriter(Book book){
        this.book = book;
    }

    @Override
    public void run() {
        synchronized (book){
            System.out.println("Thread name : " + Thread.currentThread().getName() + " started writing the book : " + book.getTitle());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread name : " + Thread.currentThread().getName() + " finished writing the book : " + book.getTitle());
            book.setCompleted(true);
            System.out.println("notify other thread waiting for the object to be available");
            book.notifyAll();
        }
    }
}
