package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author shifu = new Author("Shifu", "Sharma");
        Book book = new Book("Trouble parents!", "1234");
        shifu.getBooks().add(book);
        book.getAuthors().add(shifu);

        authorRepository.save(shifu);
        bookRepository.save(book);

        System.out.println("Bootstrap - Book count check 1 = "+bookRepository.count());

        Author shifuJr = new Author("ShifuJr", "Sharma");
        Book bookJr = new Book("Trouble parents! ++ ", "12345");
        shifu.getBooks().add(bookJr);
        book.getAuthors().add(shifuJr);

        authorRepository.save(shifuJr);
        bookRepository.save(bookJr);

        System.out.println("Bootstrap - Book count check 2 = "+bookRepository.count());
    }
}
