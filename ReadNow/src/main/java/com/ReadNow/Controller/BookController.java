package com.ReadNow.Controller;


import com.ReadNow.Entity.BookEntity;
import com.ReadNow.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/libros")
public class BookController {
    private final BookService bookService;

    // Constructor para inyección de dependencias
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Crear un nuevo libro
    @PostMapping
    public ResponseEntity<List<BookEntity>> crearLibros(@RequestBody List<BookEntity> libros) {
        // Verifica que los datos se recibieron correctamente
        System.out.println("Libros recibidos: " + libros.size());

        // Guardar los libros en la base de datos
        List<BookEntity> librosGuardados = bookService.guardarLibros(libros);

        // Retornar una respuesta con los libros guardados y un código HTTP 201 (Creado)
        return ResponseEntity.status(HttpStatus.CREATED).body(librosGuardados);
    }


    // Listar todos los libros
    @GetMapping
    public List<BookEntity> listarLibros() {
        return bookService.obtenerTodos();
    }

    // Obtener un libro por su ID
    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> obtenerLibroPorId(@PathVariable Long id) {
        return bookService.obtenerPorId(id)
                .map(libro -> ResponseEntity.ok(libro))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Eliminar un libro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        bookService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
