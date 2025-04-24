package com.ReadNow.Service;

import com.ReadNow.Entity.BookEntity;
import com.ReadNow.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Constructor para inyección de dependencias
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Obtener todos los libros
    public List<BookEntity> obtenerTodos() {
        return bookRepository.findAll();
    }

    // Obtener un libro por su ID
    public Optional<BookEntity> obtenerPorId(Long id) {
        return bookRepository.findById(id);
    }

    // Guardar un libro
    public BookEntity guardarLibro(BookEntity libro) {
        return bookRepository.save(libro);
    }

    // Eliminar un libro
    public void eliminarLibro(Long id) {
        bookRepository.deleteById(id);
    }

    // Guardar múltiples libros
    public List<BookEntity> guardarLibros(List<BookEntity> libros) {
        return bookRepository.saveAll(libros);
    }
}