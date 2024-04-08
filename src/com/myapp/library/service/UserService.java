package com.myapp.library.service;

import com.myapp.library.entities.Book;
import com.myapp.library.entities.User;

import java.util.ArrayList;
import java.util.Iterator;

public class UserService {
    private final ArrayList<User> users;

    public UserService(ArrayList<User> users){
        this.users = users;
    }

    public ArrayList<User> getAllUsers(){
        return users;
    }

    public User findById(String id){
        for (User user : users) {
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public void createUser(String name, String id){
        User user = new User();

        user.setId(id);
        user.setName(name);

        users.add(user);
    }

    public void updateUser(String id, String newName){
        for(User user : users){
            if(user.getId().equals(id)){
                user.setName(newName);
            }
        }
    }

    public void deleteUser(String id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getId().equals(id)){
                iterator.remove();
            }
        }
    }

    public void borrowBook(User user, Book book){
        if(book.isAvailable()){
            user.getBorrowedBooks().add(book);
            book.setAvailable(false);
        }
        else System.out.println("El libro no está disponible para el préstamo.");
    }

    public void returnBook(User user, Book book){
        if(user.getBorrowedBooks().contains(book)){
            user.getBorrowedBooks().remove(book);
            book.setAvailable(true);
        } else {
            System.out.println("Este libro no fue prestado por este usuario.");
        }
    }

    public ArrayList<Book> showBorrowedBooks(User user){
        return user.getBorrowedBooks();
    }
}
