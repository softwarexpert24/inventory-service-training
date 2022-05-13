package de.bredex.inventory.application.api;

public class BookDto {

    private String isbn;
    private String genre;
    private String title;
    private String author;
    
    public BookDto(String isbn, String genre, String title, String author) {
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
