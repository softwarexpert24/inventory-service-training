package de.bredex.inventory.application.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.bredex.inventory.domain.service.InventoryService;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService service;
    
    @GetMapping("/api/v1/inventory")
    public List<BookDto> getBooks() {
	return service.getBooks().stream().map(book -> new BookDto(book.getIsbn(), book.getGenre(), book.getTitle(), book.getAuthor())).collect(Collectors.toList());
    }
}
