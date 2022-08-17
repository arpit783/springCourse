package com.intializer.firstProject.bootstrap;

import com.intializer.firstProject.domain.Address;
import com.intializer.firstProject.domain.Author;
import com.intializer.firstProject.domain.Book;
import com.intializer.firstProject.domain.Publisher;
import com.intializer.firstProject.repositories.AuthorRepositories;
import com.intializer.firstProject.repositories.BookRepositories;
import com.intializer.firstProject.repositories.PublisherRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepositories authorRepositories;
    private final BookRepositories bookRepositories;
    private final PublisherRepositories publisherRepositories;

    public BootStrapData(AuthorRepositories authorRepositories, BookRepositories bookRepositories, PublisherRepositories publisherRepositories) {
        this.authorRepositories = authorRepositories;
        this.bookRepositories = bookRepositories;
        this.publisherRepositories = publisherRepositories;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher collins = new Publisher("Collins", "IPC", "Ramganjmandi", "Kota", "326519");
        publisherRepositories.save(collins);

        Author johnKeats = new Author("John", "Keats");
        Book deadPoets = new Book("Dead Poets Society", "123456");
        johnKeats.getBooks().add(deadPoets);
        deadPoets.getAuthors().add(johnKeats);
        collins.getBooks().add(deadPoets);
        deadPoets.setPublisher(collins);

        authorRepositories.save(johnKeats);
        bookRepositories.save(deadPoets);
        publisherRepositories.save(collins);

        Author robertFrost = new Author("Robert", "Frost");
        Book roadNotTaken = new Book("Road Not Taken", "654321");
//        collins = new Publisher("Collins", new Address("IPC", "Ramganjmandi", "Kota", "326519"));
        robertFrost.getBooks().add(roadNotTaken);
        roadNotTaken.getAuthors().add(robertFrost);
        collins.getBooks().add(roadNotTaken);
        roadNotTaken.setPublisher(collins);

        authorRepositories.save(robertFrost);
        bookRepositories.save(roadNotTaken);
        publisherRepositories.save(collins);

        System.out.println("Total Number of books are " + bookRepositories.count());
        System.out.println("Total Number of authors are " + authorRepositories.count());
        System.out.println("Total Number of publishers are " + publisherRepositories.count());
    }
}
