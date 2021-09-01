package challenge.catalogo_peliculas.builder;

import challenge.catalogo_peliculas.data.Pelicula;
import challenge.catalogo_peliculas.dto.PeliculaDto;

public class PeliculaBuilder {

    private String imagen;
    private String titulo;
    private int calificacion;

    public PeliculaBuilder withPeliculaDto(PeliculaDto peliculaDto){
        this.imagen = peliculaDto.getImagen();
        this.titulo = peliculaDto.getTitulo();
        this.calificacion = peliculaDto.getCalificacion();
        return this;
    }

    public Pelicula build(){
        return new Pelicula(this.imagen, this.titulo, this.calificacion);
    }
}