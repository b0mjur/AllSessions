package Session10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<String> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String book) {
        if (!book.isEmpty()) {
            books.add(book);
            System.out.println("Book added to the library " + book);
        } else {
            System.out.println("Book name is invalid");
        }
    }


    public List<String> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void displayBooks() {

        System.out.println("List of books: " + books);

    }
}
