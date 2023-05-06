package guru.springframework.spring6webapp.repos;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring6webapp.domain.Author;

public interface AuthorRepo extends CrudRepository<Author, Long>{

}
