package guru.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repos.AuthorRepo;
import guru.springframework.spring6webapp.repos.BookRepo;
import guru.springframework.spring6webapp.repos.PublisherRepo;

@Component
public class BootstrapData implements CommandLineRunner{
	
	private final AuthorRepo authRepo;
	private final BookRepo bookRepo;
	private final PublisherRepo publisherRepo;
	
	public BootstrapData(AuthorRepo authRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
		this.authRepo = authRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo = publisherRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		Author auth = new Author();
		auth.setFirstName("First Name");
		auth.setLastName("Last Name");
		
		Author auth2 = new Author();
		auth2.setFirstName("First Name 2");
		auth2.setLastName("Last Name 2");
		
		Book book = new Book();
		book.setTitle("Book Title");
		book.setIsbn("123456");
		
		Book book2 = new Book();
		book2.setTitle("Book Title 2");
		book2.setIsbn("123456");
		
		auth = authRepo.save(auth);
		book = bookRepo.save(book);
		
		auth2 = authRepo.save(auth2);
		book2 = bookRepo.save(book2); 
		
		//adding associations between saved authors and books
		auth.getBooks().add(book);
		auth2.getBooks().add(book2);
		
		Publisher publ = new Publisher();
		publ.setPublisherName("Publisher Name");
		publ.setAddress("123 Main St.");
		publ = publisherRepo.save(publ);
		
		book.setPublisher(publ);
		book2.setPublisher(publ);
		
		//after associating books, need to save to persist
		auth = authRepo.save(auth);
		auth2 = authRepo.save(auth2);
		book = bookRepo.save(book);
		book2 = bookRepo.save(book2);
			
		System.out.println("In bootstrap");
		System.out.println("Author Count: " + authRepo.count());
		System.out.println("Book Count: " + bookRepo.count());
		System.out.println("Publisher Count: " + publisherRepo.count());
	}
}
