package com.ust.movie.backendMovies.api;

import com.ust.movie.backendMovies.model.Movie;
import com.ust.movie.backendMovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "Movies/")
public class MovieController {
    private final MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping( value= "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertMovie( @RequestBody Movie movie) {
        movieService.insertMovie(movie);
    }
    @GetMapping
    public List<Movie> queryMovie() {
        return movieService.queryMovies();
    }


    @GetMapping( value="/{id}")

    Optional<Movie> queryMovie(@PathVariable("id") int id){
        return movieService.queryMovies(id);
    }



    @DeleteMapping( value="/{id}")
    public int deleteMovie( @PathVariable("{id}") int id) {
        return movieService.deleteMovie(id);
    }
    @PutMapping( value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public int updateMovie( @PathVariable("id") int id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

}
