package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.models.Author;
import guru.springframework.spring5webapp.models.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Use to add traces in command line
 * **/
@Component
public class BoostrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BoostrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author rudyard = new Author("Rudyard", "KIPLING");
        Book jungle = new Book("Le livre de la jungle", "ISBN01");

        rudyard.getBooks().add(jungle);
        jungle.getAuthors().add(rudyard);

        authorRepository.save(rudyard);
        bookRepository.save(jungle);

        Author rod = new Author("Rod", "JOHNSON");
        Book noEJB = new Book("JavaEE development without EJB", "ISBN56");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Starting in bootstrap");
        System.out.println("Books count ==> " + bookRepository.count());

    }
}
