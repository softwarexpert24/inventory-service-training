package de.bredex.inventory.application.api;

public final class BookResponse {

    private final String isbn;
    private final String genre;
    private final String title;
    private final String author;
    
    public BookResponse(final String isbn, final String genre, final String title, final String author) {
	this.isbn = isbn;
	this.genre = genre;
	this.title = title;
	this.author = author;
    }
    
    public String getIsbn() {
	return isbn;
    }
    
    public String getGenre() {
	return genre;
    }
    
    public String getTitle() {
	return title;
    }
    
    public String getAuthor() {
	return author;
    }
}
