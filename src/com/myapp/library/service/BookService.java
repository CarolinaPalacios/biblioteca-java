package com.myapp.library.service;

import com.myapp.library.entities.Book;

import java.util.ArrayList;
import java.util.Iterator;

public class BookService {
    private final ArrayList<Book> library;

    public BookService(ArrayList<Book> library){
        this.library = library;
    }

    public ArrayList<Book> getAllBooks(){
        return library;
    }

    public Book getBookByIsbn(String isbn){
        for (Book book : library) {
            if(book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> getBooksByTitle(String title){
        ArrayList<Book> searchResults = new ArrayList<>();
        for (Book book : library) {
            if(book.getTitle().toLowerCase().contains(title)){
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    public ArrayList<Book> getBooksByGenre(String genre){
        ArrayList<Book> searchResults = new ArrayList<>();
        for (Book book : library) {
            if(book.getGenre().equalsIgnoreCase(genre)){
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    public ArrayList<Book> getBooksByAuthor(String author){
        ArrayList<Book> searchResults = new ArrayList<>();
        for (Book book : library) {
            if(book.getAuthor().equalsIgnoreCase(author)){
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    public void createBook(String isbn, String title, String author, String genre){
        Book book = new Book();

        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setAvailable(true);

        library.add(book);
    }

    public void updateBook(
            String isbn,
            String newTitle,
            String newAuthor,
            String newGenre
    ){
        for(Book book : library) {
            if(book.getIsbn().equals(isbn)){
                book.setGenre(newGenre);
                book.setAuthor(newAuthor);
                book.setTitle(newTitle);
            }
        }
    }

    public void deleteBook(String isbn){
        Iterator<Book> iterator = library.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getIsbn().equals(isbn)){
                iterator.remove();
            }
        }
    }

    public boolean checkAvailability(Book book) {
        return book.isAvailable();
    }
}
