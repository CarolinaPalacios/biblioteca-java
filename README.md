<p align="center">
 <img src="https://www.svgrepo.com/show/452234/java.svg" alt="java" height="100" >
 <img src="https://www.svgrepo.com/show/277499/library-book.svg" alt="java" height="100" >
</p>

# Biblioteca Virtual en Java 

Este proyecto, realizado como proyecto final para el curso de POO en Java de Alkemy & Ministerio de Trabajo, implementa una aplicación de gestión de biblioteca en Java, utilizando conceptos de programación orientada
a objetos. Permite a los usuarios administrar el inventario de libros de una biblioteca, registrar préstamos y devoluciones, 
y realizar búsqueda en la colección de libros.

## 🛠️ Estructura del Proyecto

El proyecto se organiza en tres paquetes principales:

* `com.myapp.library.entities`

Este paquete contiene las clases `Book` y `User`, que representan los libros y usuarios de la biblioteca, respectivamente.
Cada libro tiene atributos como título, autor, ISBN, género y disponibilidad. Los usuarios tienen atributos como nombre, id
y lista de libros prestados.

* `com.myapp.library.service`

Aquí se encuentran las clases `BookService` y `UserService`, que proporcionan servicios para manipular libros y usuarios, respectivamente.
Estos servicios incluyen métodos para crear, actualizar, eliminar, buscar libros y usuarios, así como para gestionar préstamos y
devoluciones de libros.

* `com.myapp.library.ui`

El paquete `ui` contiene la clase principal `Main`, que representa la interfaz de usuario de la aplicación.
Utiliza la entrada estándar para interactuar con el usuario y realizar operaciones CRUD, solicitar préstamos y devolver libros.

## ⚙️ Uso de la Aplicación

Para ejecutar la aplicación, simplemente ejecuta la clase `Main`. Se mostrará un menú con varias opciones
para interactuar con la biblioteca virtual, como crear, actualizar y eliminar libros y usuarios, buscar libros por diferentes criterios, solicitar préstamos, devolver libros, entre otros. 
Sigue las instrucciones en pantalla para utilizar la aplicación de manera efectiva.

## 🧑🏻‍💻 Requisitos Técnicos

- Lenguaje de Programación: Java
- JDK: Se requiere tener instalado un JDK (Java Development Kit), es necesario para compilar y ejecutar el código Java en tu sistema
- IDE: Eclipse, IntelliJ IDEA (u otro de tu elección)

