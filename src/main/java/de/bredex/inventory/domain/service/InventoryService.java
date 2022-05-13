package de.bredex.inventory.domain.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import de.bredex.inventory.domain.model.Book;
import de.bredex.inventory.domain.spi.BookRepository;

@Service
public class InventoryService {

    private BookRepository repository;
    
    public InventoryService(BookRepository repository) {
	this.repository = repository;
    }
    
    public List<Book> getBooks() {
	List<Book> books = new LinkedList<>();
	repository.findAll().forEach(book -> books.add(new Book(book.getIsbn(), book.getGenre(), book.getTitle(), book.getAuthor())));
	return books;
    }
}
