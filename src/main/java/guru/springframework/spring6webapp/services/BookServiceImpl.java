package guru.springframework.spring6webapp.services;

import org.springframework.stereotype.Service;

import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repos.BookRepo;

@Service
public class BookServiceImpl implements BookService {
	
	private final BookRepo bookRepo;
	
	

	public BookServiceImpl(BookRepo bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	@Override
	public Iterable<Book> findAll() {
		return this.bookRepo.findAll();
	}

}
