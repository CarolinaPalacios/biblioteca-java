package com.myapp.library.ui;

import com.myapp.library.entities.Book;
import com.myapp.library.entities.User;
import com.myapp.library.service.BookService;
import com.myapp.library.service.UserService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> library = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();


        UserService userService = new UserService(users);
        BookService bookService = new BookService(library);

        User user1 = new User("Carolina", "123");
        User user2 = new User("Pedro", "456");
        User user3 = new User("Juan", "789");

        Book book1 = new Book("Harry Potter y el prisionero de Azkaban",
                "J.K. Rowling", "123", "Fantasia", true);
        Book book2 = new Book("El viento conoce mi nombre", "Isabel Allende",
                "456", "Literatura contemporánea", true);
        Book book3 = new Book("Indias Blancas", "Florencia Bonelli",
                "789", "Novela romántica", true);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        library.add(book1);
        library.add(book2);
        library.add(book3);

        String createISBN;
        String createTitle;
        String createAuthor;
        String createGenre;

        String updateISBN;
        String updateTitle;
        String updateAuthor;
        String updateGenre;

        String deleteISBN;

        String createUserId;
        String createUserName;

        String updateUserId;
        String updateUserName;

        String deleteUserId;

        String borrowISBN;
        String borrowUserId;

        String returnISBN;
        String returnUserId;

        String searchGenre;
        String searchAuthor;
        String searchTitle;
        String searchISBN;

        String detailId;
        String detailISBN;

        int option = 20;

     do{
            System.out.println("Menú biblioteca virtual:");
            System.out.println("1. Crear libro");
            System.out.println("2. Actualizar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Buscar libro por género");
            System.out.println("5. Buscar libro por autor");
            System.out.println("6. Buscar libro por título");
            System.out.println("7. Buscar libro por ISBN");
            System.out.println("8. Crear usuario");
            System.out.println("9. Actualizar usuario");
            System.out.println("10. Eliminar usuario");
            System.out.println("11. Ver todos los libros");
            System.out.println("12. Ver todos los usuarios");
            System.out.println("13. Solicitar préstamo de libro");
            System.out.println("14. Devolver libro prestado");
            System.out.println("15. Ver detalle de un usuario");
            System.out.println("16. Ver detalle de un libro");
            System.out.println("0. Salir");

            System.out.println("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    System.out.println("Crear libro:");

                    System.out.println("Ingresa el código ISBN: ");
                    createISBN = scanner.nextLine();

                    System.out.println("Ingresa el título: ");
                    createTitle = scanner.nextLine();

                    System.out.println("Ingresa el autor: ");
                    createAuthor = scanner.nextLine();

                    System.out.println("Ingresa el género: ");
                    createGenre = scanner.nextLine();

                    bookService.createBook(createISBN,createTitle,createAuthor,createGenre);
                    System.out.println("Libro creado exitosamente");

                    break;
                case 2:
                    System.out.println("Actualizar libro:");

                    System.out.println("Ingresa el código ISBN del libro a actualizar: ");
                    updateISBN = scanner.nextLine();

                    Book bookToUpdate = bookService.getBookByIsbn(updateISBN);

                    if(bookToUpdate != null){
                        System.out.println("Ingresa el nuevo título: ");
                        updateTitle = scanner.nextLine();

                        System.out.println("Ingresa el nuevo autor: ");
                        updateAuthor = scanner.nextLine();

                        System.out.println("Ingresa el nuevo género: ");
                        updateGenre = scanner.nextLine();

                        bookService.updateBook(updateISBN, updateTitle, updateAuthor, updateGenre);
                        System.out.println("Libro actualizado exitosamente");
                    } else {
                        System.out.println("Libro no encontrado");
                    }

                    break;
                case 3:
                    System.out.println("Eliminar libro:");

                    System.out.println("Ingresa el código ISBN del libro a eliminar");
                    deleteISBN = scanner.nextLine();

                    Book bookToDelete = bookService.getBookByIsbn(deleteISBN);

                    if(bookToDelete != null){
                        bookService.deleteBook(deleteISBN);
                        System.out.println("Libro eliminado exitosamente");
                    } else {
                        System.out.println("Libro no encontrado");
                    }

                    break;

                case 4:
                    System.out.println("Buscar libro por género:");

                    System.out.println("Ingresa el género literario para realizar la búsqueda: ");
                    searchGenre = scanner.nextLine();

                    ArrayList<Book> booksByGenre = bookService.getBooksByGenre(searchGenre);

                    if(booksByGenre.isEmpty()) {
                        System.out.println("No se encontraron libros con el género '" + searchGenre + "'");
                    } else {
                        System.out.println("Libros encontrados con el género '" + searchGenre + "':");
                        for (Book book : booksByGenre) {
                            System.out.println("- " + book.getTitle() + " (" + book.getIsbn() + "), "
                                    + book.getAuthor());
                        }
                    }

                    break;
                case 5:
                    System.out.println("Buscar libro por autor:");

                    System.out.println("Ingresa el nombre del autor para realizar la búsqueda: ");
                    searchAuthor = scanner.nextLine();

                   ArrayList<Book> booksByAuthor = bookService.getBooksByAuthor(searchAuthor);

                    if(booksByAuthor.isEmpty()) {
                        System.out.println("No se encontraron libros cuyo autor sea '" + searchAuthor + "'");
                    } else {
                        System.out.println("Libros encontrados de '" + searchAuthor + "':");
                        for (Book book : booksByAuthor) {
                            System.out.println("- " + book.getTitle() + " (" + book.getIsbn() + "), "
                                    + book.getGenre());
                        }
                    }

                    break;
                case 6:
                    System.out.println("Buscar libro por título:");

                    System.out.println("Ingresa el título del libro para realizar la búsqueda: ");
                    searchTitle = scanner.nextLine();

                    ArrayList<Book> booksByTitle =  bookService.getBooksByTitle(searchTitle);

                    if(booksByTitle.isEmpty()) {
                        System.out.println("No se encontraron libros con el título '" + searchTitle + "'");
                    } else {
                        System.out.println("Libros encontrados cuyo título incluya '" + searchTitle + "':");
                        for (Book book : booksByTitle) {
                            System.out.println("- " + book.getTitle() + " (" + book.getIsbn() + "), "
                                    + book.getAuthor() + ", " + book.getGenre());
                        }
                    }

                    break;
                case 7:
                    System.out.println("Buscar libro por código ISBN:");
                    searchISBN = scanner.nextLine();

                   Book bookByIsbn = bookService.getBookByIsbn(searchISBN);

                   if(bookByIsbn != null){
                       System.out.println("Libro encontrado: " + bookByIsbn.getTitle());
                   } else {
                       System.out.println("Libro no encontrado");
                   }

                   break;
                case 8:
                    System.out.println("Crear usuario:");

                    System.out.println("Ingresa el ID del nuevo usuario: ");
                    createUserId = scanner.nextLine();

                    System.out.println("Ingresa el nombre del nuevo usuario: ");
                    createUserName = scanner.nextLine();

                    userService.createUser(createUserName, createUserId);
                    System.out.println("Usuario creado exitosamente");

                    break;
                case 9:
                    System.out.println("Actualizar usuario:");

                    System.out.println("Ingresa el ID del usuario a actualizar: ");
                    updateUserId = scanner.nextLine();

                    User userToUpdate = userService.findById(updateUserId);

                    if(userToUpdate != null){
                        System.out.println("Nuevo nombre: ");
                        updateUserName = scanner.nextLine();

                        userService.updateUser(updateUserId, updateUserName);
                        System.out.println("Usuario actualizado exitosamente");
                    } else {
                        System.out.println("Usuario no encontrado");
                    }

                    break;
                case 10:
                    System.out.println("Eliminar usuario:");

                    System.out.println("Ingresa el ID del usuario a eliminar: ");
                    deleteUserId = scanner.nextLine();

                    User userToDelete = userService.findById(deleteUserId);

                    if(userToDelete != null){
                        userService.deleteUser(deleteUserId);
                        System.out.println("Usuario eliminado exitosamente");
                    } else {
                        System.out.println("Usuario no encontrado");
                    }

                    break;
                case 11:
                    System.out.println("Ver todos los libros:");
                    for (Book book : bookService.getAllBooks()) {
                        System.out.println(book);
                    }

                    break;
                case 12:
                    System.out.println("Ver todos los usuarios:");
                    for (User user : userService.getAllUsers()) {
                        System.out.println(user);
                    }

                    break;
                case 13:
                    System.out.println("Solicitar préstamo de libro:");

                    System.out.println("Ingresa el ID del usuario al que se le realizará el préstamo:");
                    borrowUserId = scanner.nextLine();

                    User borrowUser = userService.findById(borrowUserId);

                    if(borrowUser != null) {
                        System.out.println("Ingresa el código ISBN del libro a prestar: ");
                        borrowISBN = scanner.nextLine();
                        Book borrowBook = bookService.getBookByIsbn(borrowISBN);
                        if(borrowBook != null){
                            if(bookService.checkAvailability(borrowBook)){
                            userService.borrowBook(borrowUser, borrowBook);
                                System.out.println("El préstamo se realizó exitosamente. Libro '"
                                        + borrowBook.getTitle() + "' prestado a " + borrowUser.getName());
                            } else {
                                System.out.println("El libro no está disponible para préstamo");
                            }
                        } else {
                            System.out.println("Libro no encontrado");
                        }
                    } else {
                        System.out.println("Usuario no encontrado");
                    }

                    break;
                case 14:
                    System.out.println("Devolver libro:");

                    System.out.println("Ingresa el ID del usuario que realizará la devolución:");
                    returnUserId = scanner.nextLine();

                    User returnUser = userService.findById(returnUserId);

                    if(returnUser != null){
                        System.out.println("Ingresa el código ISBN del libro a devolver: ");
                        returnISBN = scanner.nextLine();

                        Book returnBook = bookService.getBookByIsbn(returnISBN);

                        if(returnBook != null){
                            userService.returnBook(returnUser, returnBook);
                            System.out.println("La devolución se realizó exitosamente. Libro '"
                            + returnBook.getTitle() + "' devuelto por " + returnUser.getName());
                        } else {
                            System.out.println("Libro no encontrado");
                        }
                    } else {
                        System.out.println("Usuario no encontrado");
                    }

                    break;

                case 15:
                    System.out.println("Ver detalle de un usuario:");

                    System.out.println("Ingresa el ID del usuario para ver sus datos " +
                            "y libros prestados:");
                    detailId = scanner.nextLine();

                    User userToShow = userService.findById(detailId);

                    if(userToShow != null){
                        System.out.println("ID: " + userToShow.getId() + "\nNombre: " +
                                userToShow.getName());
                        ArrayList<Book> borrowedBooks = userService.showBorrowedBooks(userToShow);

                        if(borrowedBooks.isEmpty()){
                            System.out.println("El usuario no tiene libros prestados");
                        } else {
                            System.out.println("Libros:");
                            for (Book borrowedBook : borrowedBooks) {
                                System.out.println("- " + borrowedBook.getTitle());
                            }
                        }
                    } else {
                        System.out.println("Usuario no encontrado");
                    }

                    break;
                case 16:
                    System.out.println("Ver detalle de un libro:");

                    System.out.println("Ingresa el código ISBN del libro:");
                    detailISBN = scanner.nextLine();

                    Book bookToShow = bookService.getBookByIsbn(detailISBN);

                    if(bookToShow != null) {
                        System.out.println("Detalles del libro:\nISBN: " + bookToShow.getIsbn()
                                + "\nTítulo: " + bookToShow.getTitle()  + "\nAutor: "
                                + bookToShow.getAuthor() + "\nGénero: " + bookToShow.getGenre()
                                + "\nDisponibilidad: " +
                                (bookToShow.isAvailable() ? "Disponible" : "No disponible")
                        );
                    } else {
                        System.out.println("Libro no encontrado");
                    }

                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
     while(option != 0);
    }
}