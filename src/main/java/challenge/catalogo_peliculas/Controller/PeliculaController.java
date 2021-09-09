package challenge.catalogo_peliculas.Controller;

import challenge.catalogo_peliculas.data.Pelicula;
import challenge.catalogo_peliculas.dto.PeliculaCrearDto;
import challenge.catalogo_peliculas.dto.PeliculaEditarDto;
import challenge.catalogo_peliculas.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class PeliculaController{

    @Autowired
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public ResponseEntity<?> mostrarPeliculas(){
        return new ResponseEntity<>(peliculaService.mostrarTodasPeliculas(), HttpStatus.ACCEPTED);
    }

    @GetMapping("titulo/{titulo}")
    public ResponseEntity<?> mostrarPeliculasPorTitulo(@PathVariable String titulo){
        return new ResponseEntity<>(peliculaService.buscarPorTitulo(titulo), HttpStatus.ACCEPTED);
    }

    @GetMapping("genero/{id}")
    public ResponseEntity<?> mostrarPorGenero(@PathVariable Long id){
        return new ResponseEntity<>(peliculaService.buscarTodasPelisPorGeneroId(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("orden/ASC")
    public ResponseEntity<?> mostrarPeliculasPorCreacionAscendente(){
        return new ResponseEntity<>(peliculaService.buscarPorCreacionAscendente(), HttpStatus.ACCEPTED);
    }

    @GetMapping("orden/DESC")
    public ResponseEntity<?> mostrarPeliculasPorCreacionDescendiente(){
        return new ResponseEntity<>(peliculaService.buscarPorCreacionDescendente(), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarGenero(@PathVariable Long id, @RequestBody PeliculaEditarDto peliculaDto){
        Pelicula pelicula = peliculaService.reemplazarPelicula(id, peliculaDto);
        return new ResponseEntity<>(pelicula, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> guardarPelicula(@RequestBody PeliculaCrearDto peliculaDto){
        Pelicula pelicula = peliculaService.nuevaPelicula(peliculaDto);
        return new ResponseEntity<>(pelicula, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPeliculaPorId(@PathVariable Long id){
        peliculaService.borrarPelicula(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
