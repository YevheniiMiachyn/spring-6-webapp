package guru.springframework.spring6webapp.repos;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring6webapp.domain.Publisher;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {

}
