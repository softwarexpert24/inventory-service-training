package de.bredex.inventory.domain.spi;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookDao, Integer> {

}
