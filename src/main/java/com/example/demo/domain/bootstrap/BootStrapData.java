package com.example.demo.domain.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;
@Component
public class BootStrapData implements CommandLineRunner{
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Started in Bootstraping");
		
		Publisher publisher = new Publisher();
		publisher.setName("SFG Publishing");
		publisher.setCity("Magway");
		publisher.setState("TaungDwin Gyi");
		
		publisherRepository.save(publisher);
		
		System.out.println("Publisher Count"+publisherRepository.count());
		
		
		
		Author eric = new Author("Eric","Evans");
		Book ddd = new Book("Introduced to Spring Boot","121213");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(publisher);
		
		Author shwesin =new Author("Shwe Sin","Thaw Smile");
		Book poem = new Book("Love Poem","1212134");
		shwesin.getBooks().add(poem);
		poem.getAuthors().add(shwesin);
		
		poem.setPublisher(publisher);
		publisher.getBooks().add(poem);
		
		
		authorRepository.save(shwesin);
		bookRepository.save(poem);
		publisherRepository.save(publisher);
		
		
		
		System.out.println("Number of book "+ bookRepository.count());
		System.out.println("Publiser Number of book "+ publisher.getBooks().size());

		
	}

}
