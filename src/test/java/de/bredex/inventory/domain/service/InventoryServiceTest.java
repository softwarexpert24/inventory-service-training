package de.bredex.inventory.domain.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import de.bredex.inventory.domain.model.Book;
import de.bredex.inventory.domain.service.InventoryService.NoSuchBookException;
import de.bredex.inventory.domain.spi.BookEntity;
import de.bredex.inventory.domain.spi.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InventoryServiceTest {

    private final BookRepository repository = mock(BookRepository.class);

    private InventoryService service;

    @BeforeEach
    public void setUp() {
        service = new InventoryService(repository);
    }

    @Test
    void getBooks_returns_books() {
        List<BookEntity> storedBooks = new LinkedList<>();
        storedBooks.add(new BookEntity("1-86092-022-5", "First Edition", "A Boy at Seven", "John Bidwell"));
        storedBooks.add(new BookEntity("1-86092-031-4", "Crime", "The Five Orange Pips", "Sir Arthur Conan Doyle"));
        when(repository.findAll()).thenReturn(storedBooks);

        List<Book> books = service.getBooks();

        assertThat(books).hasSize(2);
    }

    @Test
    void getBook_returns_book() {
        final BookEntity entity = new BookEntity("1-86092-022-5", "First Edition", "A Boy at Seven", "John Bidwell");
        when(repository.findByIsbn(any())).thenReturn(Optional.of(entity));

        final Book book = service.getBook("1-86092-022-5");

        assertThat(book).isNotNull();
    }

    @Test
    void getBook_throws_exception_for_non_existing_book() {
        when(repository.findByIsbn(any())).thenReturn(Optional.empty());

        assertThrows(NoSuchBookException.class, () -> service.getBook("1-86092-022-5"));
    }
}
