import java.util.Scanner;

public class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("*************************");
        System.out.println("title : " + title);
        System.out.println("-------------------------");
        System.out.println("ID : " + bookId);
        System.out.println("author : " + author);
        System.out.println("-------------------------");
    }

}

class ReferenceBook extends Book {
    String edition;

    ReferenceBook(int bookId, String title, String author, String edition) {
        super(bookId, title, author);
        this.edition = edition;
    }

    void display() {
        super.display();
        System.out.println("edition : " + edition);
        System.out.println("-------------------------");

    }
}

class FictionBook extends Book {
    String genre;

    FictionBook(int bookId, String title, String author, String genre) {
        super(bookId, title, author);
        this.genre = genre;
    }

    void display() {
        super.display();
        System.out.println("genre : " + genre);
        System.out.println("-------------------------");

    }
}

class perodical extends ReferenceBook {
    String period;

    perodical(int bookId, String title, String author, String edition, String period) {
        super(bookId, title, author, edition);
        this.edition = edition;
        this.period = period;
    }

    void display() {
        super.display();
        System.out.println("period : " + period);
        System.out.println("-------------------------");

    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book bk1 = new Book(0, "JAVA", "Kiru");
        ReferenceBook rb = new ReferenceBook(1, "Science", "Mohan", "3rd");
        FictionBook fb = new FictionBook(2, "Lion & King", "Rohan", "Fiction");
        perodical pb = new perodical(3, "Rainbow", "Rohit", "6th", "Weekly");
        bk1.display();
        fb.display();
        rb.display();
        pb.display();

        System.out.println("Enter the book details:");

        System.out.print("ID:");
        int id = sc.nextInt();

        System.out.print("auth:");
        String auth = sc.next();

        System.out.print("title:");
        String titl = sc.next();

        System.out.println("");

        if (id <= 0 || auth == null || titl == null) {
            System.out.println("not able to add book due to incorrect output");
        } else {
            Book bk2 = new Book(id, titl, auth);
            bk2.display();
        }

    }
}