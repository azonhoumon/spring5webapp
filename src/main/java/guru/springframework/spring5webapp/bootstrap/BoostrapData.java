package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.models.Author;
import guru.springframework.spring5webapp.models.Book;
import guru.springframework.spring5webapp.models.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Use to add traces in command line
 * **/
@Component
public class BoostrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BoostrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author rudyard = new Author("Rudyard", "KIPLING");
        Book jungle = new Book("Le livre de la jungle", "ISBN01");

        Publisher loreto = new Publisher("Rue Grandgagnage", "Loreto", "Namur", "5000");

        rudyard.getBooks().add(jungle);
        jungle.getAuthors().add(rudyard);
        //jungle.setPublisher(loreto);

        authorRepository.save(rudyard);
        bookRepository.save(jungle);

        Author rod = new Author("Rod", "JOHNSON");
        Book noEJB = new Book("JavaEE development without EJB", "ISBN56");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        //noEJB.setPublisher(loreto);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        loreto.getBooks().add(jungle);
        loreto.getBooks().add(noEJB);
        publisherRepository.save(loreto);

        System.out.println("Books count ==> " + bookRepository.count());
        System.out.println("Jungle's publisher ==> " + jungle.getPublisher());
        System.out.println("Publisher books size ==> " + loreto.getBooks().size());

    }
}
