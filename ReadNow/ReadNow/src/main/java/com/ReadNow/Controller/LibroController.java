package com.ReadNow.Controller;


import com.ReadNow.Entity.Libro;
import com.ReadNow.Service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Long id) {
        return libroService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroService.guardarLibro(libro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        if (!libroService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        libro.setId(id);
        return ResponseEntity.ok(libroService.guardarLibro(libro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        if (!libroService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }
}


