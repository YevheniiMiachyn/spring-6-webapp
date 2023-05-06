package guru.springframework.spring6webapp.repos;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring6webapp.domain.Book;

public interface BookRepo extends CrudRepository<Book, Long> {

}
