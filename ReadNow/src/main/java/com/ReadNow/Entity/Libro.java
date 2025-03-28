package com.ReadNow.Entity;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(Long id) {
        this.id = id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Libro setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getAutor() {
        return autor;
    }

    public Libro setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public Libro setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
        return this;
    }
}



