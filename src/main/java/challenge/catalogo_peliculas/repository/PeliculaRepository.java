package challenge.catalogo_peliculas.repository;

import challenge.catalogo_peliculas.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    
    Pelicula findByTitulo(String titulo);
    List<Pelicula> findAllByOrderByFechaCreacionAsc();
    List<Pelicula> findAllByOrderByFechaCreacionDesc();
}
