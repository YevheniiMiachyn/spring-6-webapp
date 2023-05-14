package guru.springframework.spring6webapp.services;

import org.springframework.stereotype.Service;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.repos.AuthorRepo;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	private final AuthorRepo authorRepo;
	
	

	public AuthorServiceImpl(AuthorRepo authorRepo) {
		super();
		this.authorRepo = authorRepo;
	}


	@Override
	public Iterable<Author> findAll() {
		return this.authorRepo.findAll();
	}

}
